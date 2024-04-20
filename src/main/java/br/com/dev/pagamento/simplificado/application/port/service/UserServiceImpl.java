package br.com.dev.pagamento.simplificado.application.port.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.pagamento.simplificado.application.port.in.UserService;
import br.com.dev.pagamento.simplificado.application.port.out.UserRepositoryPortOut;
import br.com.dev.pagamento.simplificado.domain.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepositoryPortOut userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.create(user);
	}

	@Override
	public User findUser(Long id) {
		return userRepository.findById(id);
	}

}
