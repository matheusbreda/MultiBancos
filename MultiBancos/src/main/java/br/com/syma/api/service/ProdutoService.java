package br.com.syma.api.service;

import java.util.List;	
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.syma.api.responses.Response;
import br.com.syma.api.model.Produto;

@Service
public interface ProdutoService {
	
	ResponseEntity<Response<Produto>> salvar (@Valid @RequestBody Produto produto, BindingResult result);
	
	List<Produto> listar();
	
	ResponseEntity<Response<Produto>> getById(String id);
	
	ResponseEntity<Response<Produto>> deleteById(String id);
	
}	
