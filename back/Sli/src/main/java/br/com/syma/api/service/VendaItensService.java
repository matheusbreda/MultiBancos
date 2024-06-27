package br.com.syma.api.service;

import java.util.List;
import org.springframework.stereotype.Service;


import br.com.syma.api.model.VendaItens;

@Service
public interface VendaItensService {
	
		List<VendaItens> listar();	
}
