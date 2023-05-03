package com.alunosprofessores.sistema.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Random;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_matriculaAluno")
public class MatriculaAluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int matricula;

    private Double nota1;

    private Double nota2;

    private StatusMatricula statusMatricula;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;


    public int gerarMatriculaAleatoria() {
        Random random = new Random();
        int numero = random.nextInt(9000) + 1000;
        return numero;
    }
}
