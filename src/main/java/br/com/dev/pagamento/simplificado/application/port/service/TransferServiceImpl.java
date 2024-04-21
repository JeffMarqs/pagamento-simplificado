package br.com.dev.pagamento.simplificado.application.port.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.pagamento.simplificado.application.exception.InsufficientFundsException;
import br.com.dev.pagamento.simplificado.application.exception.MerchantTransferPermissionDeniedException;
import br.com.dev.pagamento.simplificado.application.exception.TransactionAuthorizationFailedException;
import br.com.dev.pagamento.simplificado.application.port.in.TransferService;
import br.com.dev.pagamento.simplificado.application.port.out.TransactionValidatorPortOut;
import br.com.dev.pagamento.simplificado.application.port.out.UserRepositoryPortOut;
import br.com.dev.pagamento.simplificado.application.utils.Constant;
import br.com.dev.pagamento.simplificado.domain.dto.TransactioRequestDTO;
import br.com.dev.pagamento.simplificado.domain.dto.TransactionResponseDTO;
import br.com.dev.pagamento.simplificado.domain.dto.User;
import br.com.dev.pagamento.simplificado.domain.enums.CustomerType;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransferServiceImpl implements TransferService {

	@Autowired
	private UserRepositoryPortOut repositoryPortOut;

	@Autowired
	private TransactionValidatorPortOut transactionValidatorPortOut;

	@Override
	public TransactionResponseDTO createTransaction(TransactioRequestDTO request) {

		log.info("###### Buscando pagador ######");
		var payer = repositoryPortOut.findById(request.getPayer());

		log.info("###### Buscando beneficiário ######");
		var payee = repositoryPortOut.findById(request.getPayee());

		var transaction = new TransactionResponseDTO();

		var authorized = transactionValidatorPortOut.isAuthorized();
		
		log.info("###### Validando pagador ######");
		validateUser(payer);
		
		log.info("###### Validando saldo ######");
		performBalanceTransfer(request, payer, payee, transaction);
		
		log.info("###### Validando transação ######");
		if (authorized.equals(Constant.AUTHORIZED)) {
			
			log.info("###### Retornando transação ######");
			return transaction;


		} else {
			
			updateBalances(request, payer, payee);
			throw new TransactionAuthorizationFailedException();
		}
	}

	private void updateBalances(TransactioRequestDTO request, User userOne, User userTwo) {
		log.info("###### Atualizando saldos ######");
		userTwo.setBalance(userTwo.getBalance().subtract(request.getValue()));
		userOne.setBalance(userOne.getBalance().add(request.getValue()));
	}

	private void validateUser(User payer) {
		if (payer.getType() == CustomerType.MERCHANT)
			throw new MerchantTransferPermissionDeniedException();
	}

	private void performBalanceTransfer(TransactioRequestDTO request, User payer, User payee,
			TransactionResponseDTO transaction) {
		if (payer.getBalance().compareTo(request.getValue()) >= 0) {

			updateBalances(request, payee, payer);

			transaction.setPayer(payer);
			transaction.setPayee(payee);
			transaction.setValue(request.getValue());
		} else
			throw new InsufficientFundsException();
	}

}
