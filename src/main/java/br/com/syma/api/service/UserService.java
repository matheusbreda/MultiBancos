package br.com.syma.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.syma.api.modelAuth.User;
import br.com.syma.api.responses.Response;

@Service
public interface UserService {
	ResponseEntity<Response<User>> salvar (@Valid @RequestBody User user, BindingResult result );
	
	List<User> listar();
	
	ResponseEntity<Response<User>>  getById(Integer id);
		
	ResponseEntity<Response<User>> deleteById(Integer id);

}
