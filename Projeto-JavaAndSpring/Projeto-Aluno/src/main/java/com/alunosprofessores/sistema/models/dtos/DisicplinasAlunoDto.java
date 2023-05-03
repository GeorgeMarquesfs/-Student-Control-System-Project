package com.alunosprofessores.sistema.models.dtos;

import com.alunosprofessores.sistema.models.StatusAluno;
import lombok.Data;

@Data
public class DisicplinasAlunoDto {
    private String nomeDisciplina;
    private String professorDisciplina;
    private Double nota1;
    private Double nota2;
    private Double media;
    private StatusAluno statusAluno;
}
