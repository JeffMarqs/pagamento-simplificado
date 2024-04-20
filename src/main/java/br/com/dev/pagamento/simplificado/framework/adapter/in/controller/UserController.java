package br.com.dev.pagamento.simplificado.framework.adapter.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dev.pagamento.simplificado.application.port.in.UserService;
import br.com.dev.pagamento.simplificado.domain.dto.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok().body(userService.createUser(user));
	}
	
	@GetMapping("/find-all/{id}")
	public ResponseEntity<User> findAUser(@PathVariable Long id) {
		return ResponseEntity.ok().body(userService.findUser(id));
	}
}
