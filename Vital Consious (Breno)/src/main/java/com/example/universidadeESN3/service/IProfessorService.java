package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Professor;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {

    Optional<Professor> buscarPorId(Long id);

    List<Professor> buscarTodos();

    List<Professor> buscarPorNome(String nome);

    Professor salvar(Professor professor);

    Optional<Professor> atualizar(Professor professor);

    boolean excluir(Long id);

    boolean desativar(Long id);
}
