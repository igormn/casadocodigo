package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class Pedido {
	
	// FUNCIONALIDADE #2
	
	private Integer id;
	private BigDecimal valor;
	private Calendar data;
	private List<Produto> produtos = new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String getTitulosDosProdutos() {
		
		StringBuilder titulos = new StringBuilder();
		
		Iterator<Produto> iteratorProdutos = this.produtos.iterator();
		
		while (iteratorProdutos.hasNext()) {
			titulos.append(iteratorProdutos.next().getTitulo());
			if (iteratorProdutos.hasNext()) {
				titulos.append(", ");
			}
		}
		
		return titulos.toString();
	}
	
}
