package br.com.dev.pagamento.simplificado.framework.adapter.in.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.dev.pagamento.simplificado.application.exception.InsufficientFundsException;
import br.com.dev.pagamento.simplificado.application.exception.MerchantTransferPermissionDeniedException;
import br.com.dev.pagamento.simplificado.application.exception.TransactionAuthorizationFailedException;
import br.com.dev.pagamento.simplificado.application.exception.UserNotFoundException;
import br.com.dev.pagamento.simplificado.domain.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(MerchantTransferPermissionDeniedException.class)
	public ResponseEntity<ErrorDTO> handlerMerchantException(MerchantTransferPermissionDeniedException ex) {
		var error = "Merchant Transfer Permission Denied";
		var code = HttpStatus.FORBIDDEN.toString();
		var status = HttpStatus.FORBIDDEN.value();
		var menssage = ex.getMessage();
		
		log.warn("Merchant error: {}", menssage);
		
		var errorDTO = ErrorDTO.builder().code(code)
				.message(menssage)
				.status(status)
				.error(error).build();
		
		return ResponseEntity.status(status).body(errorDTO);
	}
	
	@ExceptionHandler(InsufficientFundsException.class)
	public ResponseEntity<ErrorDTO> handlerInsufficientFundsException(InsufficientFundsException ex) {
		var error = "Merchant Transfer Permission Denied";
		var code = HttpStatus.BAD_REQUEST.toString();
		var status = HttpStatus.BAD_REQUEST.value();
		var menssage = ex.getMessage();
		
		log.warn("Insufficient Funds error: {}", menssage);
		
		var errorDTO = ErrorDTO.builder().code(code)
				.message(menssage)
				.status(status)
				.error(error).build();
		
		return ResponseEntity.status(status).body(errorDTO);
	}
	
	@ExceptionHandler(TransactionAuthorizationFailedException.class)
	public ResponseEntity<ErrorDTO> handlerTransactionAuthorizationFailedException(TransactionAuthorizationFailedException ex) {
		var error = "Transaction Authorization Failed";
		var code = HttpStatus.FORBIDDEN.toString();
		var status = HttpStatus.FORBIDDEN.value();
		var menssage = ex.getMessage();
		
		log.warn("Transaction error: {}", menssage);
		
		var errorDTO = ErrorDTO.builder().code(code)
				.message(menssage)
				.status(status)
				.error(error).build();
		
		return ResponseEntity.status(status).body(errorDTO);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDTO> handlerUserNotFoundException(UserNotFoundException ex) {
		var error = "User Not Found";
		var code = HttpStatus.NOT_FOUND.toString();
		var status = HttpStatus.NOT_FOUND.value();
		var menssage = ex.getMessage();
		
		log.warn("User Not Found: {}", menssage);
		
		var errorDTO = ErrorDTO.builder().code(code)
				.message(menssage)
				.status(status)
				.error(error).build();
		
		return ResponseEntity.status(status).body(errorDTO);
	}
}
