package com.alunosprofessores.sistema.models.dtos;

import com.alunosprofessores.sistema.models.MatriculaAluno;
import lombok.Data;

import java.util.List;

@Data
public class HistoricoAlunoDto {

    private String aluno;
    private String curso;
    private List<DisicplinasAlunoDto> matriculasDisciplinas;
}
