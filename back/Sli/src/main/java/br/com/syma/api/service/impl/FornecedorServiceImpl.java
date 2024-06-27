package br.com.syma.api.service.impl;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import br.com.syma.api.model.Fornecedor;
import br.com.syma.api.repository.FornecedorRepository;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.FornecedorService;

@Component
public class FornecedorServiceImpl implements FornecedorService{

	@Autowired
	private FornecedorRepository repository;
	
	@Override
	public ResponseEntity<Response<Fornecedor>> salvar(@Valid Fornecedor fornecedor, BindingResult result) {
		
		Response<Fornecedor> response = new Response<Fornecedor>();
		response.setData(fornecedor);
		if(result.hasErrors()) {			
			for (ObjectError erros: result.getAllErrors()) {
				response.getErrors().add(erros.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}
		repository.save(fornecedor);		
		return ResponseEntity.ok(response);
	}

	@Override
	public List<Fornecedor> listar() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Response<Fornecedor>> getById(Integer id) {
		Response<Fornecedor> response = new Response<Fornecedor>();
		Fornecedor obj = null;
		try {
			obj = repository.findById(id).get();
		}catch(NullPointerException ex) {
			response.getErrors().add("Fornecedor inválido");
		}catch(Exception ex) {
			response.getErrors().add("Fornecedor inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Response<Fornecedor>> deleteById(Integer id) {
		Response<Fornecedor> response = new Response<Fornecedor>();
		Fornecedor obj = null;
		try {
			obj = repository.findById(id).get();
			repository.delete(obj);
		}catch(NullPointerException ex) {
			response.getErrors().add("Fornecedor inválido");
		}catch(Exception ex) {
			response.getErrors().add("Fornecedor inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}
	
	
}
