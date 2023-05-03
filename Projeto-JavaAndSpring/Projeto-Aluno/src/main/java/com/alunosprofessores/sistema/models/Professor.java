package com.alunosprofessores.sistema.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE tb_aluno SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status  = 'Ativo'")
@Table(name = "tb_professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    @Email(message = "O e-mail informado não é válido")
    private String email;

    @Column(length = 10, nullable = false)
    @Pattern(regexp = "Ativo|Inativo")
    private String status = "Ativo";

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Disciplina> disciplinas = new ArrayList<>();


}
