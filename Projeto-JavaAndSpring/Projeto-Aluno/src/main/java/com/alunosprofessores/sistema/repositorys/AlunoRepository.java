package com.alunosprofessores.sistema.repositorys;

import com.alunosprofessores.sistema.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
