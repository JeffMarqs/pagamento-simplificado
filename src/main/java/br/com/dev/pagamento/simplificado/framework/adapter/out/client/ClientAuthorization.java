package br.com.dev.pagamento.simplificado.framework.adapter.out.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.dev.pagamento.simplificado.domain.validator.AuthorizationMessage;

@FeignClient(name = "api-authorized", url = "https://run.mocky.io/v3")
public interface ClientAuthorization {

	@GetMapping("/5794d450-d2e2-4412-8131-73d0293ac1cc")
	public AuthorizationMessage isAuthorized();
}
