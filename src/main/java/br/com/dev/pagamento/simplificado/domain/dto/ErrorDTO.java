package br.com.dev.pagamento.simplificado.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO {
	
	private Integer status;
	private String message;
	private String code;
	private String error;

}
