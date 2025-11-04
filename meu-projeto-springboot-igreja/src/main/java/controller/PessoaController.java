package controller;

import model.Pessoa;
import repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/pessoas") // Certifique-se de que o mapeamento da URL está correto
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    // Endpoint para cadastrar uma nova pessoa
    @PostMapping
    public Pessoa cadastrarPessoa(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa); // Salva a pessoa no banco e retorna ela
    }

    // Endpoint para listar todas as pessoas cadastradas
    @GetMapping
    public List<Pessoa> listarPessoas() {
        return pessoaRepository.findAll(); // Retorna todas as pessoas cadastradas
    }

    // Endpoint para buscar pessoas pelo nome
    @GetMapping("/buscar")
    public List<Pessoa> buscarPessoas(@RequestParam String nome) {
        return pessoaRepository.findByNomeContainingIgnoreCase(nome); // Busca por nome
    }
}
