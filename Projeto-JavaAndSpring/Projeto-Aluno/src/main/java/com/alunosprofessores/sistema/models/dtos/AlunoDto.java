package com.alunosprofessores.sistema.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDto {

    private String nome;
    private Long matricula;
    private LocalDate dataNasc;
    private String email;
    private String curso;

}
