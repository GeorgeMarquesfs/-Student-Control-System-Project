package com.alunosprofessores.sistema.repositorys;

import com.alunosprofessores.sistema.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
