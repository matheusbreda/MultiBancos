package br.com.syma.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.syma.api.model.Cliente;
import br.com.syma.api.responses.Response;

@Service
public interface ClienteService {
	
	ResponseEntity<Response<Cliente>> salvar(@Valid @RequestBody Cliente cliente, BindingResult result);
	
	List<Cliente> listar();
	
	ResponseEntity<Response<Cliente>> getById(String id);
	
	ResponseEntity<Response<Cliente>> deleteById(String id);
	
}
