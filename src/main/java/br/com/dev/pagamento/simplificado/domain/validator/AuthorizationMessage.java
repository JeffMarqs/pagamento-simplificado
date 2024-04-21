package br.com.dev.pagamento.simplificado.domain.validator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorizationMessage {
	
	private String message;

}
