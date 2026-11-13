package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Aluno;
import com.example.universidadeESN3.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlunoService implements IAlunoService {

    private final AlunoRepository alunoRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Aluno> buscarPorNome(String nome) {
        return alunoRepository.findByNomeStartingWithIgnoreCase(nome);
    }

    @Override
    @Transactional
    public Aluno salvar(Aluno aluno) {
        log.info("salvar() - aluno: {}", aluno);
        if (aluno.getActive() == null) {
            aluno.setActive(Boolean.TRUE);
        }
        return alunoRepository.save(aluno);
    }

    @Override
    @Transactional
    public Optional<Aluno> atualizar(Aluno aluno) {
        if (aluno.getId() == null) {
            return Optional.empty();
        }
        return alunoRepository.findById(aluno.getId())
                .map(existing -> {
                    existing.setMatricula(aluno.getMatricula());
                    existing.setNome(aluno.getNome());
                    existing.setGenero(aluno.getGenero());
                    if (aluno.getActive() != null) {
                        existing.setActive(aluno.getActive());
                    }
                    log.info("atualizar() - aluno: {}", existing);
                    return alunoRepository.save(existing);
                });
    }

    @Override
    @Transactional
    public boolean excluir(Long id) {
        if (!alunoRepository.existsById(id)) {
            return false;
        }
        alunoRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional
    public boolean desativar(Long id) {
        return alunoRepository.findById(id)
                .map(aluno -> {
                    aluno.setActive(Boolean.FALSE);
                    alunoRepository.save(aluno);
                    return true;
                })
                .orElse(false);
    }
}
