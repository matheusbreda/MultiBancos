package br.com.syma.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Entity
@Data
public class Cliente {
	
	@Id
	private String id;
	
	@Column
	@Valid
	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	@Column
	private String endereco;
	
	@Column(nullable = false, length = 11)
	@Valid
	@NotNull(message = "{campo.cpf.obrigatorio}")
	@CPF(message = "{campo.cpf.invalido}")
	private String cpf;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;
	
}
