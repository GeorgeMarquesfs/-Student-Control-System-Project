package com.alunosprofessores.sistema.services;

import com.alunosprofessores.sistema.models.dtos.AlunoDto;
import com.alunosprofessores.sistema.models.Aluno;

import java.util.List;

public interface IAlunoService {

    Aluno createAlunoService(AlunoDto alunoDTO);

    Aluno getAluno(Long id);
    List<Aluno> getAll();
    Aluno updateAluno(Long id,Aluno alunoAtt);
    void deleteAluno(Long id);
}
