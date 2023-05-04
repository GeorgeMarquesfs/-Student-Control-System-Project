package com.alunosprofessores.sistema.repositorys;

import com.alunosprofessores.sistema.models.MatriculaAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaAlunoRepository extends JpaRepository<MatriculaAluno, Long> {
    List<MatriculaAluno> findAllByAlunoId(Long alunoId);
}
