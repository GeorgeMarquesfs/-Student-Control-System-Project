package com.alunosprofessores.sistema.controllers;

import com.alunosprofessores.sistema.dtos.AlunoDTO;
import com.alunosprofessores.sistema.models.Aluno;
import com.alunosprofessores.sistema.services.AlunoService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/aluno")
@CrossOrigin(origins = "*")
public class AlunoController {

    @Autowired
    AlunoService alunoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Aluno> createAluno(@RequestBody @Validated AlunoDTO alunoDTO) {
        Aluno alunoCreated = alunoService.createAlunoService(alunoDTO);
        return ResponseEntity.status(201).body(alunoCreated);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Aluno getAluno( @PathVariable @Positive Long id) {
        return alunoService.getAluno(id);

    }

    @GetMapping("/ListarAlunos")
    public ResponseEntity<List<Aluno>> getAll() {
        return new ResponseEntity<>(alunoService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable @Positive Long id, @RequestBody @Validated Aluno alunoAtt) {
        return new ResponseEntity<>(alunoService.updateAluno(id,alunoAtt),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAluno(@PathVariable @Positive Long id) {
        alunoService.deleteAluno(id);
    }
}
