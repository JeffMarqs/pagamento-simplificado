package br.com.dev.pagamento.simplificado.application.port.out;

import br.com.dev.pagamento.simplificado.domain.dto.User;

public interface UserRepositoryPortOut {

	User findById(Long payer);

	User create(User user);

}
