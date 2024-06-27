package br.com.syma.api.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.com.syma.api.model.VendaItens;
import br.com.syma.api.repository.VendaItensRepository;
import br.com.syma.api.service.VendaItensService;

@Component
public class VendaItensServiceImpl implements VendaItensService {
	
	@Autowired
	private VendaItensRepository repository;
	
	@Override
	public List<VendaItens> listar() {
		return repository.findAll();
	}
}
