package com.alunosprofessores.sistema.models.dtos;


import com.alunosprofessores.sistema.models.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDto {

    private String nome;
    private Integer cargaHoraria;
    private Professor professor;
}
