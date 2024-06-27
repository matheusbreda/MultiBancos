package br.com.syma.api.service.impl;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import br.com.syma.api.model.Cliente;
import br.com.syma.api.repository.ClienteRepository;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.ClienteService;

@Component
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public ResponseEntity<Response<Cliente>> salvar(@Valid Cliente cliente, BindingResult result) {
		
		if( (cliente.getId() == null) || (cliente.getId().equals("") )) {
			UUID uuid = UUID.randomUUID();
			String uuidAsString = uuid.toString();
			cliente.setId(uuidAsString);			
		}
		
		Response<Cliente> response = new Response<Cliente>();
		response.setData(cliente);
		if(result.hasErrors()) {			
			for (ObjectError erros: result.getAllErrors()) {
				response.getErrors().add(erros.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}
		repository.save(cliente);		
		return ResponseEntity.ok(response);
		
	}

	@Override
	public List<Cliente> listar() {		
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Response<Cliente>> getById(String id) {		
		Response<Cliente> response = new Response<Cliente>();
		Cliente obj = null;
		try {			
			obj = repository.findById(id).get();
		}catch(NullPointerException ex) {
			response.getErrors().add("Cliente inválido");
		}catch(Exception ex) {
			response.getErrors().add("Cliente inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Response<Cliente>> deleteById(String id) {
		
		Response<Cliente> response = new Response<Cliente>();
		Cliente obj = null;
		try {
			obj = repository.findById(id).get();
			repository.delete(obj);
		}catch(NullPointerException ex) {
			response.getErrors().add("Cliente inválido");
		}catch(Exception ex) {
			response.getErrors().add("Cliente inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}

}
