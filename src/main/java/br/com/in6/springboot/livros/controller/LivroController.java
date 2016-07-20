package br.com.in6.springboot.livros.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.in6.springboot.livros.entity.Livro;
import br.com.in6.springboot.livros.repository.LivroRepository;

@Controller
@RequestMapping("/livros")
public class LivroController {
	
	private LivroRepository livroRepository;

	@Autowired
	public LivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String lista(Model model) {
		Iterator<Livro> iter = livroRepository.findAll().iterator();
		List<Livro> listaLivros = new ArrayList<Livro>(0);
		while (iter.hasNext())
			listaLivros.add(iter.next());
		
		if (listaLivros != null) {
			model.addAttribute("livros", listaLivros);
		}
		return "listaLivros";
	}

	@RequestMapping(value = "/{autor}", method = RequestMethod.GET)
	public String listaLivros(@PathVariable("autor") String autor, Model model) {
		List<Livro> listaLivros = livroRepository.findByAutor(autor);
		if (listaLivros != null) {
			model.addAttribute("livros", listaLivros);
		}
		return "listaLivros";
	}

	@RequestMapping(value = "/{autor}", method = RequestMethod.POST)
	public String adicionaLivroAutor(@PathVariable("autor") String autor, Livro livro) {
		livro.setAutor(autor);
		livroRepository.save(livro);
		return "redirect:/{autor}";
	}
}
