package br.com.syma.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.syma.api.dto.VendaCidadeDTO;

@Service
public interface VendaCidadeService {

	List<VendaCidadeDTO> listar();
}
