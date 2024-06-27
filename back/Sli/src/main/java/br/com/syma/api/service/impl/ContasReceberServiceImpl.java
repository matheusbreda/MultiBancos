package br.com.syma.api.service.impl;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import br.com.syma.api.model.ContasReceber;
import br.com.syma.api.repository.ContasReceberRepository;
import br.com.syma.api.responses.Response;
import br.com.syma.api.service.ContasReceberService;

@Component
public class ContasReceberServiceImpl implements ContasReceberService{

	@Autowired
	private ContasReceberRepository repository;
	
	@Override
	public ResponseEntity<Response<ContasReceber>> salvar(@Valid ContasReceber contasReceber, BindingResult result) {
		Response<ContasReceber> response = new Response<ContasReceber>();
		response.setData(contasReceber);
		if(result.hasErrors()) {			
			for (ObjectError erros: result.getAllErrors()) {
				response.getErrors().add(erros.getDefaultMessage());
			}
			return ResponseEntity.badRequest().body(response);
		}
		repository.save(contasReceber);		
		return ResponseEntity.ok(response);
	}
	
	public ResponseEntity<Response<ContasReceber>> salvarLista(@Valid ContasReceber[] ListaContasReceber, BindingResult result) {
		Response<ContasReceber> response = new Response<ContasReceber>();
		for (ContasReceber contasReceber : ListaContasReceber) {
			response.setData(contasReceber);
			if(result.hasErrors()) {			
				for (ObjectError erros: result.getAllErrors()) {
					response.getErrors().add(erros.getDefaultMessage());
				}
				return ResponseEntity.badRequest().body(response);
			}
			repository.save(contasReceber);	
		}
		return ResponseEntity.ok(response);
	}

	@Override
	public List<ContasReceber> listar() {
		return repository.findAll();
	}

	@Override
	public ResponseEntity<Response<ContasReceber>> getById(Integer id) {
		Response<ContasReceber> response = new Response<ContasReceber>();
		ContasReceber obj = null;
		try {
			obj = repository.findById(id).get();
		}catch(NullPointerException ex) {
			response.getErrors().add("Recebimento inválido");
		}catch(Exception ex) {
			response.getErrors().add("Recebimento inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Response<ContasReceber>> deleteById(Integer id) {
		Response<ContasReceber> response = new Response<ContasReceber>();
		ContasReceber obj = null;
		try {
			obj = repository.findById(id).get();
			repository.delete(obj);
		}catch(NullPointerException ex) {
			response.getErrors().add("Recebimento inválido");
		}catch(Exception ex) {
			response.getErrors().add("Recebimento inválido");
		}
		response.setData(obj);		
		return ResponseEntity.ok(response);
	}
	
	
}
