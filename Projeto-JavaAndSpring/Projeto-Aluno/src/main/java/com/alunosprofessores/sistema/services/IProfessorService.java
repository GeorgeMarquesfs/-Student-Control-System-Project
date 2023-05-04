package com.alunosprofessores.sistema.services;

import com.alunosprofessores.sistema.models.Disciplina;
import com.alunosprofessores.sistema.models.dtos.ProfessorDto;
import com.alunosprofessores.sistema.models.Professor;

import java.util.List;

public interface IProfessorService {

    Professor createProf(ProfessorDto professorDTO);
    Professor getProfessor(Long id);
    List<Disciplina> getOnlyDisciplinasProfessor(Long id);
    List<Professor> getAllProf();
    Professor updateProfessor(Long id, ProfessorDto professorAtt);
    void deleteProf(Long id);
}
