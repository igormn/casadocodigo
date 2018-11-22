package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.models.Pedido;

@Controller
@RequestMapping("/pedidos")
public class PedidosServicoController {
	
	// FUNCIONALIDADE #2
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("pedidos/pedidos");
		
		String uri = "https://book-payment.herokuapp.com/orders";
		
		Pedido[] pedidos = this.restTemplate.getForObject(uri, Pedido[].class);
		
		modelAndView.addObject("pedidos", pedidos);
		
		return modelAndView;
	}
	
}
