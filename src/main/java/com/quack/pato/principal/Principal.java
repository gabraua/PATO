package com.quack.pato.principal;

import com.quack.pato.service.ConsumoApi;

public class Principal {

	private final String URL_BASE = "https://random-d.uk/api/quack";
	private ConsumoApi consumo = new ConsumoApi();

	public void exibeMenu() {
		var json = consumo.obterDados(URL_BASE);
		System.out.println("Dados recebidos da API: " + json);
	}
}

