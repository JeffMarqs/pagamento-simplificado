package br.com.dev.pagamento.simplificado.application.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException(Long id) {
		super("User id " + id + " not found in the database.");
	}

}
