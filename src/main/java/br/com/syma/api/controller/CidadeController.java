package br.com.syma.api.controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.syma.api.model.Cidade;
import br.com.syma.api.repository.CidadeRepository;

@RestController
@RequestMapping("/api/cidade")
@CrossOrigin(origins="*", maxAge = 3600)
public class CidadeController {
	
	@Autowired 
	private CidadeRepository repository;
	
	@PostMapping
	@ResponseStatus( HttpStatus.CREATED)
	 private ResponseEntity salvar(@RequestBody Cidade cidade) {
		if( (cidade.getId() == null) || (cidade.getId().equals("") )) {
			UUID uuid = UUID.randomUUID();
			String uuidAsString = uuid.toString();
			cidade.setId(uuidAsString); 		
		}
		try {
			repository.save(cidade);
			return ResponseEntity.ok(cidade);
		} catch (Exception e) {
			e.printStackTrace();
			return (ResponseEntity) ResponseEntity.noContent();	
		}
	}
	
	@GetMapping
	public List<Cidade> getAll() {
		List<Cidade> lista = repository.findAll();
		for (Cidade cidade : lista) {
			System.out.println(cidade);
		}
		return repository.findAll();	
	}
	
	@GetMapping("/{id}")
	public Cidade getById(@PathVariable String id) {
		return repository.findById(id).get();
	}
	
	@PutMapping
	public Cidade update(@RequestBody Cidade cidade) {
		return repository.save(cidade);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		Cidade obj = repository.findById(id).get();
		repository.delete(obj);
	}
}

