package br.com.syma.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Fornecedor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column
	private String nome;

	@Column
	private String endereco;

	@Column
	private String cnpj;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	private Cidade cidade;

}
