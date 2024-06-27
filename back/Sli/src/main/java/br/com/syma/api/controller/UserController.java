package br.com.syma.api.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.syma.api.model.User;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.impl.UserServiceImpl;


@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="*", maxAge = 3600)
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<User>> inserir(@Valid @RequestBody User user, BindingResult result ){		    
		return service.salvar(user, result);
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<User>> alterar(@Valid @RequestBody User user, BindingResult result ){		    
		return service.salvar(user, result);		
	}
	
	@GetMapping
	public List<User> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<User>> getById(@PathVariable Integer id){
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code  = HttpStatus.NO_CONTENT)
	public ResponseEntity<Response<User>> deleteById(@PathVariable Integer id){
		return service.deleteById(id);
	}


}
