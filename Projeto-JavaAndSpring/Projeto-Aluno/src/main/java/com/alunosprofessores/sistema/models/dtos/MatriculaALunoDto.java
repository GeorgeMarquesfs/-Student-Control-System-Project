package com.alunosprofessores.sistema.models.dtos;

import com.alunosprofessores.sistema.models.Aluno;
import com.alunosprofessores.sistema.models.Disciplina;
import com.alunosprofessores.sistema.models.StatusMatricula;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaALunoDto {

    private Double nota1;

    private Double nota2;

    private StatusMatricula statusMatricula;

    private Aluno aluno;

    private Disciplina disciplina;

}
