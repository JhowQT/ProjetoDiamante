package com.br.fiap.ProjetoBank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.fiap.ProjetoBank.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
    
}
