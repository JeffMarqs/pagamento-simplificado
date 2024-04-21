package br.com.dev.pagamento.simplificado.application.exception;

public class InsufficientFundsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InsufficientFundsException() {
		super("Payer doesn't have enough money to make the transfer.");
	}

}
