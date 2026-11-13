package com.example.universidadeESN3.controller;

import com.example.universidadeESN3.entity.Professor;
import com.example.universidadeESN3.service.IProfessorService;
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
@RequestMapping("/professor")
@RequiredArgsConstructor
@Slf4j
public class ProfessorController {

    private final IProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> listarTodos() {
        return ResponseEntity.ok(professorService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id) {
        return professorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Professor>> buscarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok(professorService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<Professor> criar(@RequestBody Professor professor) {
        log.info("criar() - professor: {}", professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.salvar(professor));
    }

    @PutMapping
    public ResponseEntity<Professor> atualizar(@RequestBody Professor professor) {
        if (professor.getId() == null) {
            return ResponseEntity.badRequest().build();
        }
        return professorService.atualizar(professor)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!professorService.excluir(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inactive/{id}")
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        if (!professorService.desativar(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
