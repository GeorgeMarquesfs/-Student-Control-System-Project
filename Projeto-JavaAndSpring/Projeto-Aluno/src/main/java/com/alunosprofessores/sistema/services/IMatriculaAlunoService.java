package com.alunosprofessores.sistema.services;

import com.alunosprofessores.sistema.models.MatriculaAluno;
import com.alunosprofessores.sistema.models.dtos.MatriculaALunoDto;

import java.util.List;

public interface IMatriculaAlunoService {

    MatriculaAluno create(MatriculaAluno matriculaALuno);
    MatriculaAluno getDisciplina(Long id);
    List<MatriculaAluno> getAll();
    MatriculaALunoDto updateDisciplina(Long id, MatriculaALunoDto matriculaALunoDto);
    void deleteMatriculaAluno(Long id);
}
