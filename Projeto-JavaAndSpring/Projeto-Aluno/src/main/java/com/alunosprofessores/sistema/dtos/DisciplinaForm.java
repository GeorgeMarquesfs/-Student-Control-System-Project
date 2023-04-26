package com.alunosprofessores.sistema.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaForm {

    private String nome;
    private Integer cargaHoraria;
}
