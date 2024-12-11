package com.quack.pato.principal;

import com.quack.pato.model.DadosApi;
import com.quack.pato.service.ConsumoApi;
import com.quack.pato.service.ConvertePatos;

public class Principal {

	private final String URL_BASE = "https://random-d.uk/api/quack";
	private ConsumoApi consumo = new ConsumoApi();

	public void exibeMenu() {
		var json = consumo.obterDados(URL_BASE);
		System.out.println("json: " + json);
		
		ConvertePatos conversor = new ConvertePatos();
		DadosApi dados = conversor.obterDados(json, DadosApi.class);
		System.out.println(dados);
	}
}
