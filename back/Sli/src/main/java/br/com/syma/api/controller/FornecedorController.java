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
import br.com.syma.api.model.Fornecedor;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.impl.FornecedorServiceImpl;


@RestController
@RequestMapping("/api/fornecedor")
@CrossOrigin(origins="*", maxAge = 3600)
public class FornecedorController {
	
	@Autowired
	private FornecedorServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Fornecedor>> inserir(@Valid @RequestBody Fornecedor fornecedor, BindingResult result ){		    
		return service.salvar(fornecedor, result);
		
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Fornecedor>> alterar(@Valid @RequestBody Fornecedor fornecedor, BindingResult result ){		    
		return service.salvar(fornecedor, result);		
	}
	
	@GetMapping
	public List<Fornecedor> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Fornecedor>> getById(@PathVariable Integer id){
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code  = HttpStatus.NO_CONTENT)
	public ResponseEntity<Response<Fornecedor>> deleteById(@PathVariable Integer id){
		return service.deleteById(id);
	}


}
