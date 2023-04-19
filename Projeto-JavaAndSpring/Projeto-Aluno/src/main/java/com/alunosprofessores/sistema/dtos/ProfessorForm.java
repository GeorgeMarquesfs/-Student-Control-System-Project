package com.alunosprofessores.sistema.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorForm {

    private String nome;
    private List<String> listaCadeirasFacul = new ArrayList<>();
}
