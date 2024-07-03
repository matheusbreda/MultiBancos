package br.com.syma.api.service.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import br.com.syma.api.responses.Response;
import br.com.syma.api.model.Produto;
import br.com.syma.api.repository.ProdutoRepository;
import br.com.syma.api.service.ProdutoService;

@Component
public class ProdutoServiceImpl implements ProdutoService{
	
	@Autowired
	private ProdutoRepository repository;
	
	@Override
	public ResponseEntity<Response<Produto>> salvar(@Valid Produto produto, BindingResult result) {
		if( (produto.getId() == null) || (produto.getId().equals("") )) {
			UUID uuid = UUID.randomUUID();
			String uuidAsString = uuid.toString();
			produto.setId(uuidAsString);			
		}
		Response<Produto> response = new Response<Produto>();
		response.setData(produto);
		if(result.hasErrors()) {
			for(ObjectError erros : result.getAllErrors()) {	
					response.getErrors().add(erros.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}
		repository.save(produto);
		return ResponseEntity.ok(response);
	}

	@Override
	public List<Produto> listar() { 
		return repository.findAll();
	}
	
	@Override
	public ResponseEntity<Response<Produto>> getById(String id) { 		
		Response<Produto> response = new Response<Produto>();
		Produto obj = null;
		try {
			obj = repository.findById(id).get();
		} catch (NullPointerException ex) {
			response.getErrors().add("Produto invalido");
		} catch (Exception ex) {
			response.getErrors().add("Produto invalido");
		}
		response.setData(obj);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Response<Produto>> deleteById(String id) {
		Response<Produto> response = new Response<Produto>();
		Produto obj = null;
		try {
			obj = repository.findById(id).get();
			repository.delete(obj);
		} catch (NullPointerException ex) {
			response.getErrors().add("Produto invalido");
		} catch (Exception ex) {
			response.getErrors().add("Produto invalido");
		}
		response.setData(obj);
		return ResponseEntity.ok(response);
	}

}
