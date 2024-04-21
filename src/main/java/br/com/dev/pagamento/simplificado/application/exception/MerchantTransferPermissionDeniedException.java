package br.com.dev.pagamento.simplificado.application.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantTransferPermissionDeniedException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public MerchantTransferPermissionDeniedException() {
		super("Users of the Merchant type cannot make transfers, only receive them.");
	}
	
	
}
