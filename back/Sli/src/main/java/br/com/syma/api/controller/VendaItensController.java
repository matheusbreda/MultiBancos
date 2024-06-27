package br.com.syma.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.syma.api.model.VendaItens;
import br.com.syma.api.service.impl.VendaItensServiceImpl;

@RestController
@RequestMapping("/api/venda-itens")
@CrossOrigin(origins="*", maxAge = 3600)
public class VendaItensController {
		
		@Autowired
		private VendaItensServiceImpl service;
		
		@GetMapping
		public List<VendaItens> listar(){
			return service.listar();
		}
	
}
