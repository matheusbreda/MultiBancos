package br.com.syma.api.service.impl;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import br.com.syma.api.model.User;
import br.com.syma.api.repository.UserRepository;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.UserService;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;
	
	@Override
	public ResponseEntity<Response<User>> salvar(@Valid User user, BindingResult result) {
		
		Response<User> response = new Response<User>();
		response.setData(user);
		if(result.hasErrors()) {			
			for (ObjectError erros: result.getAllErrors()) {
				response.getErrors().add(erros.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}
		repository.save(user);		
		return ResponseEntity.ok(response);
	}

	@Override
	public List<User> listar() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Response<User>> getById(Integer id) {
		Response<User> response = new Response<User>();
		User obj = null;
		try {
			obj = repository.findById(id).get();
		}catch(NullPointerException ex) {
			response.getErrors().add("User inválido");
		}catch(Exception ex) {
			response.getErrors().add("User inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Response<User>> deleteById(Integer id) {
		Response<User> response = new Response<User>();
		User obj = null;
		try {
			obj = repository.findById(id).get();
			repository.delete(obj);
		}catch(NullPointerException ex) {
			response.getErrors().add("User inválido");
		}catch(Exception ex) {
			response.getErrors().add("User inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}
	
	
}
