package br.com.dev.pagamento.simplificado.application.port.in;

import br.com.dev.pagamento.simplificado.domain.dto.User;

public interface UserService {

	User createUser(User user);

	User findUser(Long id);

}
