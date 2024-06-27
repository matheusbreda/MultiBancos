package br.com.syma.api.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class ContasReceber {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.ALL})
	@JoinColumn(name = "id_venda")
	private Venda venda;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataVencimento = LocalDate.now();
	
	@Column
	private int quantidade;
	
	@Column
	private int nrParcela;
	
	@Column
	private double valorParcela;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataPagamento = LocalDate.now();
	
	@Column
	private double valorMulta;
	
	@Column
	private double valorJuros;
	
	@Column
	private double valorPago;

}
