package com.alunosprofessores.sistema.services;

import com.alunosprofessores.sistema.models.dtos.DisciplinaDto;
import com.alunosprofessores.sistema.models.Disciplina;

import java.util.List;

public interface IDisciplinaService {

    Disciplina create(DisciplinaDto disciplinaDTO);
    DisciplinaDto getDisciplina(Long id);
    List<Disciplina> getAll();
    Disciplina updateDisciplina(Long id, Disciplina disciplinaAtt);
    void deleteDisciplina(Long id);


}
