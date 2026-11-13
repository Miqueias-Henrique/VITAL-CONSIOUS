package com.example.universidadeESN3.controller;

import com.example.universidadeESN3.entity.Aluno;
import com.example.universidadeESN3.service.IAlunoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
@Slf4j
public class AlunoController {

    private final IAlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> listarTodos() {
        return ResponseEntity.ok(alunoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(alunoService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<Aluno> criar(@RequestBody Aluno aluno) {
        log.info("criar() - aluno: {}", aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.salvar(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
        if (aluno.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return alunoService.atualizar(aluno)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!alunoService.excluir(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inactive/{id}")
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        if (!alunoService.desativar(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
