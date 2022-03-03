package com.musica.musica.controllers;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.musica.musica.models.Musica;
import com.musica.musica.repository.MusicaRepository;

@Controller
public class MusicaController {

	@Autowired
	private MusicaRepository mr;
	
	@RequestMapping(value = "/cadastrarMusica", method = RequestMethod.GET)
	public String form(){
		return "musica/formMusica";
		}
	
	@RequestMapping(value = "/cadastrarMusica", method = RequestMethod.POST)
	public String form(@Valid Musica musica, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos...");
			return "redirect:/cadastrarMusica";
		}
		
		mr.save(musica);
		attributes.addFlashAttribute("mensagem", "Música adicionada com sucesso!");
		return "redirect:/cadastrarMusica";
	}
	
	@RequestMapping("/musicas")
    public ModelAndView listaMusicas() {
    	ModelAndView mv = new ModelAndView("musica/listaMusica");
    	Iterable<Musica>musicas = mr.findAll();
    	mv.addObject("musicas", musicas);
    	return mv;
    	
    }
	
	@RequestMapping(value = "/musica/{codigo}", method = RequestMethod.GET)
	public ModelAndView detalhesMusica(@PathVariable("codigo") long codigo) {
		Musica musica = mr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("musica/detalhesMusica");
		mv.addObject("musica", musica);
		
		return mv;
	}
	
	@RequestMapping("/deletarMusica")
	public String deletarMusica(long codigo) {
		Musica musica = mr.findByCodigo(codigo);
		mr.delete(musica);
		return "redirect:/musicas";
	}
	
	@RequestMapping(value="/editar-musica", method = RequestMethod.GET)
	public ModelAndView editarMusica(long codigo) {
		Musica musica = mr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("musica/update-musica");
		mv.addObject("musica", musica);
		return mv;
	}
	
	@RequestMapping(value = "/editar-musica", method = RequestMethod.POST)
	public String updateMusica(@Valid Musica musica, BindingResult result, RedirectAttributes attributes) {
		mr.save(musica);
		attributes.addFlashAttribute("sucess", "Musica alterada com sucesso!");
		
		long codigolong = musica.getCodigo();
		String codigo = "" + codigolong;
		return "redirect:/" + codigo;
	}
}
