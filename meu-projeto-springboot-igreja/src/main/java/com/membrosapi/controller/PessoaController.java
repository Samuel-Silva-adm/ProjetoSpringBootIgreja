package com.membrosapi.controller;

import com.membrosapi.model.Pessoa;
import com.membrosapi.repository.PessoaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private static final Logger logger = LoggerFactory.getLogger(PessoaController.class);

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        logger.info("POST /api/pessoas - criando pessoa: {}", pessoa);
        try {
            Pessoa salvo = pessoaRepository.save(pessoa);
            logger.info("Pessoa criada com id={}", salvo.getId());
            return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
        } catch (Exception e) {
            logger.error("Erro ao salvar pessoa", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao salvar pessoa: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        logger.debug("GET /api/pessoas - listando");
        return ResponseEntity.ok(pessoaRepository.findAll());
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Pessoa>> buscarPessoas(@RequestParam String nome) {
        logger.debug("GET /api/pessoas/buscar?nome={}", nome);
        return ResponseEntity.ok(pessoaRepository.findByNomeContainingIgnoreCase(nome));
    }

    // Novo: obter por id
    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable Long id) {
        logger.debug("GET /api/pessoas/{}", id);
        Optional<Pessoa> p = pessoaRepository.findById(id);
        return p.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Novo: atualizar pessoa
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        logger.info("PUT /api/pessoas/{} - payload: {}", id, pessoa);
        Optional<Pessoa> opt = pessoaRepository.findById(id);
        if (opt.isEmpty()) {
            logger.warn("Tentativa de atualizar pessoa inexistente id={}", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        try {
            Pessoa existente = opt.get();
            existente.setNome(pessoa.getNome());
            existente.setTipoOportunidade(pessoa.getTipoOportunidade());
            existente.setDataCulto(pessoa.getDataCulto());
            Pessoa salvo = pessoaRepository.save(existente);
            logger.info("Pessoa id={} atualizada com sucesso", salvo.getId());
            return ResponseEntity.ok(salvo);
        } catch (Exception e) {
            logger.error("Erro ao atualizar pessoa id=" + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

    // Novo: deletar pessoa
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPessoa(@PathVariable Long id) {
        logger.info("DELETE /api/pessoas/{}", id);
        Optional<Pessoa> opt = pessoaRepository.findById(id);
        if (opt.isEmpty()) {
            logger.warn("Tentativa de deletar pessoa inexistente id={}", id);
            return ResponseEntity.notFound().build();
        }
        try {
            pessoaRepository.deleteById(id);
            logger.info("Pessoa id={} deletada", id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Erro ao deletar pessoa id=" + id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao deletar pessoa: " + e.getMessage());
        }
    }
}
