package br.com.dev.pagamento.simplificado.application.exception;

public class TransactionAuthorizationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TransactionAuthorizationFailedException() {
		super("Transaction was not authorized, try again later.");
	}

}
