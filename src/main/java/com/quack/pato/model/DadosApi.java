package com.quack.pato.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosApi(@JsonAlias("message") String mensagem,@JsonAlias("url") String url ) {
	
	

}
