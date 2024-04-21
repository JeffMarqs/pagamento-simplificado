package br.com.dev.pagamento.simplificado.framework.adapter.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.pagamento.simplificado.application.port.in.TransferService;
import br.com.dev.pagamento.simplificado.domain.dto.TransactioRequestDTO;
import br.com.dev.pagamento.simplificado.domain.dto.TransactionResponseDTO;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/simplified-payment")
@Slf4j
public class TransferController {
	
	@Autowired
	private TransferService transferService;

	@PostMapping("/transfer")
	public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody TransactioRequestDTO request) {
		
		log.info("###### Iniciando Transação ######");
		
		return ResponseEntity.ok().body(transferService.createTransaction(request));
	}
	
}
