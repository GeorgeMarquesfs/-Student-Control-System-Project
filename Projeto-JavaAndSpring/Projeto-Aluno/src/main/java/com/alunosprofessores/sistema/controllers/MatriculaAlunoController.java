package com.alunosprofessores.sistema.controllers;

import com.alunosprofessores.sistema.models.MatriculaAluno;
import com.alunosprofessores.sistema.services.IMatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    IMatriculaAlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MatriculaAluno> create(MatriculaAluno matriculaAluno){
        MatriculaAluno matriculaAluno1 = service.create(matriculaAluno);
        return ResponseEntity.status(201).body(matriculaAluno1);
    }
}
