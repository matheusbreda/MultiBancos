package br.com.syma.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "venda_itens")
public class VendaItens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	private Double valorUnitario;
	private Double valorTotal;
	private int quantidade;
	
	@JsonBackReference
	@ManyToOne(cascade = {CascadeType.REMOVE, CascadeType.ALL})
	@JoinColumn(name="id_venda")			
	private Venda venda = new Venda();
	
	@ManyToOne		
	@JoinColumn(name="id_produto")
	private Produto produto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public VendaItens() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Item Venda id= "+
				" Produto: " + produto.getDescricao() +
				" valor unitario: " + valorUnitario + 
				" Quantidade: " + quantidade + 
				" Valor total: " + valorTotal;
	}

	
	
	

}
