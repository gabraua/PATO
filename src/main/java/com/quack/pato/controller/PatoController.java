package com.quack.pato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quack.pato.service.ConsumoApi;

@Controller
@RequestMapping("/")
public class PatoController {

    private final String URL_BASE = "https://random-d.uk/api/quack";
    private ConsumoApi consumo = new ConsumoApi();

    @GetMapping
    public String home(Model model) {
        return "patoHome";
    }

    @GetMapping("/pato")
    public String getPato(Model model) {
        var json = consumo.obterDados(URL_BASE);
        System.out.println("Dados recebidos da API: " + json);
        return "patoHome";
    }
}
