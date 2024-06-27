package br.com.syma.api.service.impl;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import br.com.syma.api.model.TabelaPreco;
import br.com.syma.api.repository.TabelaPrecoRepository;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.TabelaPrecoService;

@Component
public class TabelaPrecoServiceImpl implements TabelaPrecoService {
	
	@Autowired
	private TabelaPrecoRepository repository;

	@Override
	public ResponseEntity<Response<TabelaPreco>> salvar(@Valid TabelaPreco tabelaPreco, BindingResult result) {
		Response<TabelaPreco> response = new Response<TabelaPreco>();		
		response.setData(tabelaPreco);		
		if(result.hasErrors()) {			
			for (ObjectError erros: result.getAllErrors()) {
				response.getErrors().add(erros.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}
		repository.save(tabelaPreco);				
		return ResponseEntity.ok(response);
	}

	@Override
	public List<TabelaPreco> listar() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Response<TabelaPreco>> getById(Integer id) {
		Response<TabelaPreco> response = new Response<TabelaPreco>();		
		TabelaPreco obj = null;
		try {
			obj = repository.findById(id).get();
		}catch(NullPointerException ex) {
			response.getErrors().add("Tabela de Preço inválido");
		}catch(Exception ex) {
			response.getErrors().add("Tabela de Preço inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Response<TabelaPreco>> deleteById(Integer id) {
		Response<TabelaPreco> response = new Response<TabelaPreco>();		
		TabelaPreco obj = null;		
		try {
			obj = repository.findById(id).get();
			repository.delete(obj);
		}catch(NullPointerException ex) {
			response.getErrors().add("Tabela de Preço inválido");
		}catch(Exception ex) {
			response.getErrors().add("Tabela de Preço inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}

}
