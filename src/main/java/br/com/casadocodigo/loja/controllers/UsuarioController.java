package br.com.casadocodigo.loja.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.dao.RoleDAO;
import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired // FUNCIONALIDADE #3
	private UsuarioDAO usuarioDAO;
	
	@Autowired // FUNCIONALIDADE #4
	private RoleDAO roleDAO;
	
	// FUNCIONALIDADE #3
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		
		List<Usuario> usuarios = this.usuarioDAO.listar();
		
		modelAndView.addObject("usuarios", usuarios);
		
		return modelAndView;
	}
	
	// FUNCIONALIDADE #3
	@RequestMapping("/form")
	public ModelAndView form(Usuario usuario) {
		return new ModelAndView("usuarios/form");
	}
	
	// FUNCIONALIDADE #3
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
		if (bindingResult.hasErrors()) {
			return this.form(usuario);
		}
		
		usuario.criptografaSenha(usuario.getSenha());
		this.usuarioDAO.gravar(usuario);
		
		redirectAttributes.addFlashAttribute("message", "Usuário cadastrado com sucesso!");
		
		return new ModelAndView("redirect:/usuarios");
		
	}
	
	// FUNCIONALIDADE #3
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    binder.addValidators(new UsuarioValidation());
	}
	
	// FUNCIONALIDADE #3
	@ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView trataRegistroExistente(DataIntegrityViolationException exception) {
		ModelAndView modelAndView = new ModelAndView("usuarios/form");
		modelAndView.addObject("message", "Usuário já existe na base de dados da Casa do Código!");
		modelAndView.addObject("usuario", new Usuario());
		return modelAndView;
    }
	
	// FUNCIONALIDADE #4
	@RequestMapping("/editar/{email:.+}")
	public ModelAndView editarPermissoes(@PathVariable("email") String email) {
		ModelAndView modelAndView = new ModelAndView("usuarios/editarRoles");
		
		modelAndView.addObject("usuario", this.usuarioDAO.loadUserByUsername(email));
		modelAndView.addObject("roles", this.roleDAO.listar());
		
		return modelAndView;
	}
	
	// FUNCIONALIDADE #4
	@Transactional
	@RequestMapping(value="/gravarPermissoes", method=RequestMethod.POST)
	public ModelAndView gravarPermissoes(Usuario usuario, RedirectAttributes redirectAttributes) {
		
		Usuario usuarioEncontrado = this.usuarioDAO.loadUserByUsername(usuario.getEmail());
		usuarioEncontrado.setRoles(usuario.getRoles());
		
		this.usuarioDAO.atualizarPermissoes(usuarioEncontrado);
		
		redirectAttributes.addFlashAttribute("message", "Permissões alteradas com sucesso!");
		
		return new ModelAndView("redirect:/usuarios");
		
	}
	
}
