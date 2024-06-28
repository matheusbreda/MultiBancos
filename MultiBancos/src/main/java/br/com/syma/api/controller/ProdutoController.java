package br.com.syma.api.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.syma.api.responses.Response;
import br.com.syma.api.model.Produto;
import br.com.syma.api.service.impl.ProdutoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin(origins="*", maxAge = 3600)
public class ProdutoController {
	
	@Autowired
	private ProdutoServiceImpl service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Produto>> salvar(@Valid @RequestBody Produto produto, BindingResult result) {		
		return service.salvar(produto, result);
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<Produto>> alterar(@Valid @RequestBody Produto produto, BindingResult result) {		
		return service.salvar(produto, result);
	}
	
	@GetMapping
	public List<Produto> Listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Response<Produto>> getById(@PathVariable String id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<Response<Produto>> deleteById(@PathVariable String id) {
		return service.deleteById(id);
	}
	
}
