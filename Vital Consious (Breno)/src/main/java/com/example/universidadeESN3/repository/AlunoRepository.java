package com.example.universidadeESN3.repository;

import com.example.universidadeESN3.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findByNomeStartingWithIgnoreCase(String nome);
}
