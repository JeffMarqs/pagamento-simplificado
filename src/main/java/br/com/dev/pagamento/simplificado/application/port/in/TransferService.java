package br.com.dev.pagamento.simplificado.application.port.in;

import br.com.dev.pagamento.simplificado.domain.dto.TransactioRequestDTO;
import br.com.dev.pagamento.simplificado.domain.dto.TransactionResponseDTO;

public interface TransferService {

	TransactionResponseDTO createTransaction(TransactioRequestDTO request);

}
