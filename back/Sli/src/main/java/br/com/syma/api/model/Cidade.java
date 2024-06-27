package br.com.syma.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cidade {
	
	@Id
	private String id;
	
	@Column
	private String nome;
	
	@Column
	private String uf;
	
}
