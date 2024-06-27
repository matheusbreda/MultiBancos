package br.com.syma.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.syma.api.model.Fornecedor;
import br.com.syma.api.responses.Response;

@Service
public interface FornecedorService {
	ResponseEntity<Response<Fornecedor>> salvar (@Valid @RequestBody Fornecedor fornecedor, BindingResult result );
	
	List<Fornecedor> listar();
	
	ResponseEntity<Response<Fornecedor>>  getById(Integer id);
		
	ResponseEntity<Response<Fornecedor>> deleteById(Integer id);

}
