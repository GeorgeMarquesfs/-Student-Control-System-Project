package com.alunosprofessores.sistema.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "professor_id")
    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Professor professor;
}


//UPDATE tb_disciplina SET professor_nome = (SELECT nome FROM tb_professor WHERE id = professor_id)
