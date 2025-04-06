package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Professor;
import com.example.universidadeESN3.repository.ProfessorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProfessorService implements IProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Professor> buscarTodos() {
        return null;
    }

    @Override
    public Professor salvar(Professor professor) {
        return null;
    }

    @Override
    public void atualizar(Professor professor) {

    }

    @Override
    public void excluir(Long id) {

    }
}
