package br.com.casadocodigo.loja.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.RelatorioProduto;

@Controller
public class RelatorioProdutosController {
	
	// FUNCIONALIDADE #1
	
	@Autowired
	private ProdutoDAO produtoDAO;
	
	@GetMapping("/relatorio-produtos")
	@ResponseBody
	public RelatorioProduto buscarTodosOsProdutos(@RequestParam(required=false, name="data") String data) throws ParseException {
		
		List<Produto> produtos = null;
		if (data == null) {
			produtos = this.produtoDAO.listar();
		} else {
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
			produtos = this.produtoDAO.buscarTodosOsProdutos(formatador.parse(data));
		}
		
		RelatorioProduto relatorioProduto = new RelatorioProduto();
		relatorioProduto.setDataGeracao(Calendar.getInstance());
		relatorioProduto.setQuantidade(produtos.size());
		relatorioProduto.setProdutos(produtos);
		
		return relatorioProduto;
	}
	
}
