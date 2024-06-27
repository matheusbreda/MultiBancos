package br.com.syma.api.service;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.syma.api.model.ContasReceber;
import br.com.syma.api.responses.Response;

@Service
public interface ContasReceberService {
	
	ResponseEntity<Response<ContasReceber>> salvar (@Valid @RequestBody ContasReceber contasReceber, BindingResult result);
	
	List<ContasReceber> listar();
	
	ResponseEntity<Response<ContasReceber>> getById(Integer id);
	
	ResponseEntity<Response<ContasReceber>> deleteById(Integer id);

}
