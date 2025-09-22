package com.br.fiap.ProjetoBank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.br.fiap.ProjetoBank.model.Conta;
import com.br.fiap.ProjetoBank.repository.ContaRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class ContaController {
    
    @Autowired
    private ContaRepository contaRepository;

    @GetMapping
    public String testeGet(){
        log.info("TESTE  DO SPRING");
        return "TESTE SUCESSO";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Conta createConta(@RequestBody @Valid Conta conta){
        log.info("Criando uma conta" + conta);
        return contaRepository.save(conta);
    }



    private Conta getContaById(Long id){
        return contaRepository
                    .findById(id)
                    .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Processo não disponivel para o ID" + id)
                    );
    }

}
