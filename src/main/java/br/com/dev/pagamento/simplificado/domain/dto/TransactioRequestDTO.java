package br.com.dev.pagamento.simplificado.domain.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactioRequestDTO {
	
	private BigDecimal value;
	private Long payer;
	private Long payee;

}
