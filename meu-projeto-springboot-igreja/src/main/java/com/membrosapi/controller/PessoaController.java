package com.membrosapi.controller;

import com.membrosapi.model.Pessoa;
import com.membrosapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/buscar")
    public List<Pessoa> buscarPessoas(@RequestParam String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome);
    }
}

