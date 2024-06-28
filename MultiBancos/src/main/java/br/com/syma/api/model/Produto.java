package br.com.syma.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Entity
@Data
public class Produto {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column
	@Valid
	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;
	
	@Column
	private Double quantidade;
	
	@Column
	private Double valor;
	
}
