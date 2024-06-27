package br.com.syma.api.service.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import br.com.syma.api.model.Venda;
import br.com.syma.api.repository.VendaRepository;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.VendaService;

@Component
public class VendaServiceImpl implements VendaService{
	
	@Autowired
	private VendaRepository repository;

	@Override
public ResponseEntity<Response<Venda>> salvar(@Valid Venda venda, BindingResult result) {
		
		if( (venda.getId() == null) || (venda.getId().equals("") )) {
			UUID uuid = UUID.randomUUID();
			String uuidAsString = uuid.toString();
			venda.setId(uuidAsString);			
		}
		
		Response<Venda> response = new Response<Venda>();
		response.setData(venda);
		if(result.hasErrors()) {			
			for (ObjectError erros: result.getAllErrors()) {
				response.getErrors().add(erros.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}
		repository.save(venda);		
		return ResponseEntity.ok(response);
		
	}

	@Override
	public List<Venda> listar() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Response<Venda>> getById(String id) {
		Response<Venda> response = new Response<Venda>();
		Venda obj = null;
		try {
			obj = repository.findById(id).get();
		}catch(NullPointerException ex) {
			response.getErrors().add("Venda inválido");
		}catch(Exception ex) {
			response.getErrors().add("Venda inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Response<Venda>> deleteById(String id) {		
		Response<Venda> response = new Response<Venda>();				
		Venda obj = null;
		try {
			obj = repository.findById(id).get();			
			repository.delete(obj);
		}catch(NullPointerException ex) {
			response.getErrors().add("Venda inválido");
		}catch(Exception ex) {
			response.getErrors().add("Venda inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}

}

