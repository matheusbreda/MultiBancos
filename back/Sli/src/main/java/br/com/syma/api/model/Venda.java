package br.com.syma.api.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "venda")
public class Venda {
	
	@Id
	private String id;
		
	private Double valorTotal;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data = LocalDate.now();
	
	@ManyToOne	
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@JsonManagedReference
	@OneToMany(mappedBy="venda", cascade =  {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<VendaItens> itens = new ArrayList<VendaItens>();
	
	public void adicionarItem(VendaItens item) {
		item.setVenda(this);
		this.itens.add(item);		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<VendaItens> getItens() {
		return itens;
	}

	public void setItens(List<VendaItens> itens) {
		this.itens = itens;
	}

	public Venda() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Venda(String id, Double valorTotal, LocalDate data, Cliente cliente, List<VendaItens> itens) {
		super();
		this.id = id;
		this.valorTotal = valorTotal;
		this.data = data;
		this.cliente = cliente;
		this.itens = itens;
	}
	
	@Override
	public String toString() {
		return "Venda " + id + ", valorTotal=" + valorTotal + ", data=" + data + ", cliente=" + cliente + "itens: " + itens;
	}

}


