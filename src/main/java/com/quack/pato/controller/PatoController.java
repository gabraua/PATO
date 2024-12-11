package com.quack.pato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quack.pato.model.DadosApi;
import com.quack.pato.service.ConsumoApi;
import com.quack.pato.service.ConvertePatos;

@Controller
@RequestMapping("/")
public class PatoController {

	private final String URL_BASE = "https://random-d.uk/api/quack";
	private ConsumoApi consumo = new ConsumoApi();

	@GetMapping
	public String home() {
		return "patoHome";
	}

	@GetMapping("/pato")
	public String getPato(Model model) {
		var json = consumo.obterDados(URL_BASE);
		
		ConvertePatos conversor = new ConvertePatos();
		DadosApi dados = conversor.obterDados(json, DadosApi.class);
		
		System.out.println(dados);
		System.out.println(dados.url());
		model.addAttribute("url",dados.url());

		return "patoHome";
	}
}
