package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Aluno;

import java.util.List;
import java.util.Optional;

public interface IAlunoService {

    Optional<Aluno> buscarPorId(Long id);

    List<Aluno> buscarTodos();

    List<Aluno> buscarPorNome(String nome);

    Aluno salvar(Aluno aluno);

    Optional<Aluno> atualizar(Aluno aluno);

    boolean excluir(Long id);

    boolean desativar(Long id);
}
