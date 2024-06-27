package br.com.syma.api.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VendaCidadeDTO {
	
	@Id
	private String cidade;  
	private String produto;
	private String valor;
	
	
        
}

	


