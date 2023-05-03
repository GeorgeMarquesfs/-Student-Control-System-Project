package com.alunosprofessores.sistema.models.dtos;

import com.alunosprofessores.sistema.models.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDto {

    private String nome;
    private String email;
    private List<Disciplina> disciplinas;


}
