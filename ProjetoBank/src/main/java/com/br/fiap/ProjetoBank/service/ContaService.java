package com.br.fiap.ProjetoBank.service;

import com.br.fiap.ProjetoBank.model.Conta;
import com.br.fiap.ProjetoBank.repository.ContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class ContaService {

    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Transactional
    public Conta criarConta(Conta conta) {
        // Validações de negócio
        if (conta.getDataAbertura().isAfter(LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data de abertura não pode ser no futuro");
        }
        if (conta.getSaldo().compareTo(BigDecimal.ZERO) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo inicial não pode ser negativo");
        }
        conta.setAtivo(true); // Nova conta sempre ativa
        return contaRepository.save(conta);
    }

    public List<Conta> listarContas() {
        return contaRepository.findAll();
    }

    public Conta buscarContaPorId(Long id) {
        return contaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada"));
    }

    @Transactional
    public Conta encerrarConta(Long id) {
        Conta conta = buscarContaPorId(id);
        conta.setAtivo(false);
        return contaRepository.save(conta);
    }

    @Transactional
    public Conta depositar(Long id, BigDecimal valor) {
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor inválido para depósito");
        }
        
        Conta conta = buscarContaPorId(id);
        if (!conta.getAtivo()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta inativa não pode receber depósito");
        }
        
        conta.setSaldo(conta.getSaldo().add(valor));
        return contaRepository.save(conta);
    }

    @Transactional
    public Conta sacar(Long id, BigDecimal valor) {
        Conta conta = buscarContaPorId(id);
        
        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Valor inválido para saque");
        }
        if (!conta.getAtivo()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Conta inativa não pode realizar saque");
        }
        if (conta.getSaldo().compareTo(valor) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo insuficiente");
        }
        
        conta.setSaldo(conta.getSaldo().subtract(valor));
        return contaRepository.save(conta);
    }

    @Transactional
    public Conta transferir(Long idOrigem, Long idDestino, BigDecimal valor) {
        // Primeiro sacar da origem (já valida saldo e conta ativa)
        Conta origem = sacar(idOrigem, valor);
        
        // Depois depositar no destino
        depositar(idDestino, valor);
        
        return origem; // retorna a conta de origem atualizada
    }
}