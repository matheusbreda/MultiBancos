package br.com.syma.api.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.syma.api.model.Venda;
import br.com.syma.api.responses.Response;

@Service
public interface VendaService {
	
	public ResponseEntity<Response<Venda>> salvar(@Valid @RequestBody Venda venda, BindingResult result );
	
	public List<Venda> listar();
	
	public ResponseEntity<Response<Venda>>  getById(String id);
		
	public ResponseEntity<Response<Venda>> deleteById(String id);

}
