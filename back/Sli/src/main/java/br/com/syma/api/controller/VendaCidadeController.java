package br.com.syma.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.syma.api.dto.VendaCidadeDTO;
import br.com.syma.api.service.impl.VendaCidadeServiceImpl;

@RestController
@RequestMapping("/api/venda-cidade")
@CrossOrigin(origins="*", maxAge = 3600)
public class VendaCidadeController {
	
	@Autowired
	private VendaCidadeServiceImpl service;
	
	@GetMapping
	public List<VendaCidadeDTO> listar(){
		return service.listar();
	}
}
