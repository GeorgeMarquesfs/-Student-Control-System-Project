package com.alunosprofessores.sistema.services.Impl;

import com.alunosprofessores.sistema.models.MatriculaAluno;
import com.alunosprofessores.sistema.models.StatusMatricula;
import com.alunosprofessores.sistema.models.dtos.MatriculaALunoDto;
import com.alunosprofessores.sistema.repositorys.MatriculaAlunoRepository;
import com.alunosprofessores.sistema.services.IMatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaAlunoImpl implements IMatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    @Override
    public MatriculaAluno create(MatriculaAluno matriculaALuno) {
        matriculaALuno.setStatusMatricula(StatusMatricula.MATRICULADO);
        matriculaALuno.setMatricula(matriculaALuno.gerarMatriculaAleatoria());
        return matriculaAlunoRepository.save(matriculaALuno);
    }

    @Override
    public MatriculaAluno getDisciplina(Long id) {
        return null;
    }

    @Override
    public List<MatriculaAluno> getAll() {
        return null;
    }

    @Override
    public MatriculaALunoDto updateDisciplina(Long id, MatriculaALunoDto matriculaALunoDto) {
        return null;
    }

    @Override
    public void deleteMatriculaAluno(Long id) {

    }
}
