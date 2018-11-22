package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RelatorioProduto {
	
	// FUNCIONALIDADE #1
	
	private Calendar dataGeracao;
	private Integer quantidade;
	private List<Produto> produtos = new ArrayList<>();
	
	public Calendar getDataGeracao() {
		return dataGeracao;
	}
	public void setDataGeracao(Calendar dataGeracao) {
		this.dataGeracao = dataGeracao;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
