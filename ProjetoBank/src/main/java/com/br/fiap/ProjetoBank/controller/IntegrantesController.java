package com.br.fiap.ProjetoBank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntegrantesController {
    
    
    @GetMapping("/")
    public String integrantesProjeto() {
        return "Integrantes: \n"+
        "RM560601:Jhonatan Quispe Torrez   \n" + 
        "RM560293:Julia Damasco Busso";
    }
}