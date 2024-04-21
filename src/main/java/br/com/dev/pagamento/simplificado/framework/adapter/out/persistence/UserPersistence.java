package br.com.dev.pagamento.simplificado.framework.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dev.pagamento.simplificado.application.exception.UserNotFoundException;
import br.com.dev.pagamento.simplificado.application.port.out.UserRepositoryPortOut;
import br.com.dev.pagamento.simplificado.domain.dto.User;
import br.com.dev.pagamento.simplificado.framework.adapter.out.repository.UserRepository;

@Service
public class UserPersistence implements UserRepositoryPortOut {
	
	@Autowired
	private UserRepository repository;

	@Override
	public User findById(Long payer) {
		var obj = repository.findById(payer);
		
		if(obj.isPresent())
			return obj.get();
		
		else
			throw new UserNotFoundException(payer);
	}

	@Override
	public User create(User user) {
		return repository.save(user);
	}

}
