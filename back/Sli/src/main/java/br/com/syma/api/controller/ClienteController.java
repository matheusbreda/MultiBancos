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
import br.com.syma.api.model.Cliente;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.impl.ClienteServiceImpl;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins="*", maxAge = 3600)
public class ClienteController {
	
	
	@Autowired
	private ClienteServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Cliente>> inserir(@Valid @RequestBody Cliente cliente, BindingResult result ){		    
		return service.salvar(cliente, result);
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Cliente>> alterar(@Valid @RequestBody Cliente cliente, BindingResult result ){		    
		return service.salvar(cliente, result);		
	}
	
	@GetMapping
	public List<Cliente> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Cliente>> getById(@PathVariable String id){
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code  = HttpStatus.NO_CONTENT)
	public ResponseEntity<Response<Cliente>> deleteById(@PathVariable String id){
		return service.deleteById(id);
	}

}





