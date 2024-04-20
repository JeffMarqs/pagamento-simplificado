package br.com.dev.pagamento.simplificado.framework.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.dev.pagamento.simplificado.domain.dto.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
