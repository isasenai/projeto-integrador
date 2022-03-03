package com.musica.musica.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.musica.musica.models.Musica;

import com.musica.musica.repository.MusicaRepository;

@Controller
public class BuscaController {

	@Autowired
	private MusicaRepository mr;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView abrirIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {
		
		ModelAndView mv = new ModelAndView("index");
		String mensagem = "Resultados da busca por " + buscar;
		
		if(nome.equals(nome)) {
			mv.addObject("musicas", mr.findByNomesMusica(buscar));
		}
		
		mv.addObject("mensagem", mensagem);
		return mv;
		
	}
	
	
}
