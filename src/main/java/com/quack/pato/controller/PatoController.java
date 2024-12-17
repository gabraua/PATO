package com.quack.pato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quack.pato.model.DadosApi;
import com.quack.pato.model.UrlManager;
import com.quack.pato.service.ConsumoApi;
import com.quack.pato.service.ConvertePatos;

@Controller
@RequestMapping("/")
public class PatoController {

	private final String URL_BASE = "https://random-d.uk/api/quack";
	private ConsumoApi consumo = new ConsumoApi();
	private UrlManager url = new UrlManager();

	@GetMapping
	public String home() {
		return "patoHome";
	}

	@GetMapping("/pato")
	public String getPato(Model model) {
		var json = consumo.obterDados(URL_BASE);

		ConvertePatos conversor = new ConvertePatos();
		DadosApi dados = conversor.obterDados(json, DadosApi.class);

		url.addUrl(dados.url());
		model.addAttribute("url", dados.url());
		System.out.println(dados.url());
		return "patoHome";
	}

	@GetMapping("/historico")
	public String showUrls(Model model) {
		model.addAttribute("urls", url.getUrls());
		return "patoList";
	}

	@PostMapping("/removeUrl")
	public String removeUrl(@RequestParam("url") String urlToRemove, Model model) {
		// Remove a URL da lista
		url.getUrls().removeIf(u -> u.equals(urlToRemove));

		// Atualiza a lista de URLs no modelo
		model.addAttribute("urls", url.getUrls());

		// Redireciona para a página da lista de URLs após a remoção
		return "redirect:/urls";
		// Redireciona para a página de listagem de URLs
	}

}
