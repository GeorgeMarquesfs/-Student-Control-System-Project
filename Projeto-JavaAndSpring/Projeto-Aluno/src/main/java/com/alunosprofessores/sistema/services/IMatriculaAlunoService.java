package com.alunosprofessores.sistema.services;

import com.alunosprofessores.sistema.models.MatriculaAluno;
import com.alunosprofessores.sistema.models.dtos.HistoricoAlunoDto;
import com.alunosprofessores.sistema.models.dtos.NotasAlunosDto;

import java.util.List;

public interface IMatriculaAlunoService {

    MatriculaAluno create(MatriculaAluno matriculaALuno);
    MatriculaAluno getMatriculaAluno(Long id);
    List<MatriculaAluno> getAll();
    void updateMatricula(Long id);
    MatriculaAluno updateNotasAluno(Long id, NotasAlunosDto notasAlunosDto);
    List<HistoricoAlunoDto> historicoAlunos(Long id);

    void deleteMatriculaAluno(Long id);
}
