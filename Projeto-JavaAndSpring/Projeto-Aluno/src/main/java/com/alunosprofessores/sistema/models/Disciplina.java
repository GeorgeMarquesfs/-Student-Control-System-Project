package com.alunosprofessores.sistema.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_disciplina")
public class Disciplina {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private Integer cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;
}
