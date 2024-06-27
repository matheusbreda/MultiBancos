package br.com.syma.api.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.syma.api.model.TabelaPreco;
import br.com.syma.api.responses.Response;

@Service
public interface TabelaPrecoService {
	
ResponseEntity<Response<TabelaPreco>> salvar(@Valid @RequestBody TabelaPreco tabelaPreco, BindingResult result);
	
	List<TabelaPreco> listar();
	
	ResponseEntity<Response<TabelaPreco>> getById(Integer id);
	
	ResponseEntity<Response<TabelaPreco>> deleteById(Integer id);

}
