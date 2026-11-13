package com.example.universidadeESN3.service;

import com.example.universidadeESN3.entity.Professor;
import com.example.universidadeESN3.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfessorService implements IProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Professor> buscarPorId(Long id) {
        return professorRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Professor> buscarPorNome(String nome) {
        return professorRepository.findByNomeStartingWithIgnoreCase(nome);
    }

    @Override
    @Transactional
    public Professor salvar(Professor professor) {
        log.info("salvar() - professor: {}", professor);
        if (professor.getActive() == null) {
            professor.setActive(Boolean.TRUE);
        }
        return professorRepository.save(professor);
    }

    @Override
    @Transactional
    public Optional<Professor> atualizar(Professor professor) {
        if (professor.getId() == null) {
            return Optional.empty();
        }
        return professorRepository.findById(professor.getId())
                .map(existing -> {
                    existing.setMatricula(professor.getMatricula());
                    existing.setNome(professor.getNome());
                    if (professor.getActive() != null) {
                        existing.setActive(professor.getActive());
                    }
                    log.info("atualizar() - professor: {}", existing);
                    return professorRepository.save(existing);
                });
    }

    @Override
    @Transactional
    public boolean excluir(Long id) {
        if (!professorRepository.existsById(id)) {
            return false;
        }
        professorRepository.deleteById(id);
        return true;
    }

    @Override
    @Transactional
    public boolean desativar(Long id) {
        return professorRepository.findById(id)
                .map(professor -> {
                    professor.setActive(Boolean.FALSE);
                    professorRepository.save(professor);
                    return true;
                })
                .orElse(false);
    }
}
