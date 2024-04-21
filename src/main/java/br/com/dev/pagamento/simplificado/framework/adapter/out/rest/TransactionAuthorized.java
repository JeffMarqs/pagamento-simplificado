package br.com.dev.pagamento.simplificado.framework.adapter.out.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.pagamento.simplificado.application.port.out.TransactionValidatorPortOut;
import br.com.dev.pagamento.simplificado.framework.adapter.out.client.ClientAuthorization;

@Service
public class TransactionAuthorized implements TransactionValidatorPortOut {
	
	@Autowired
	private ClientAuthorization authorization;

	@Override
	public String isAuthorized() {
		return authorization.isAuthorized().getMessage();
	}

}
