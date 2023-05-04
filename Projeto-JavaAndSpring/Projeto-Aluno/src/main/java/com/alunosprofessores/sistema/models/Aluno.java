package com.alunosprofessores.sistema.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE tb_aluno SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status  = 'Ativo'")
@Table(name = "tb_aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;

    @NotNull(message = "O celular não pode ser nulo")
    private String celular;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    @NotNull(message = "A data de nascimento não pode ser nulo")
    private LocalDate dataNasc;

    @Column(nullable = false, length = 100)
    @Email(message = "O e-mail informado não é válido")
    @NotNull(message = "O email não pode ser nulo")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "O curso não pode ser nulo")
    private String curso;

    @Column(length = 10, nullable = false)
    @Pattern(regexp = "Ativo|Inativo")
    private String status = "Ativo";
}
