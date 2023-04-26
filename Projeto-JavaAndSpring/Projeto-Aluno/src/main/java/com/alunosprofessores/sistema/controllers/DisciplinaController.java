package com.alunosprofessores.sistema.controllers;

import com.alunosprofessores.sistema.dtos.AlunoDTO;
import com.alunosprofessores.sistema.dtos.DisciplinaDTO;
import com.alunosprofessores.sistema.models.Aluno;
import com.alunosprofessores.sistema.models.Disciplina;
import com.alunosprofessores.sistema.services.DisciplinaService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    DisciplinaService disciplinaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Disciplina> createDisciplina(@RequestBody @Validated DisciplinaDTO disciplinaDTO){
        Disciplina disciplinaCreated = disciplinaService.create(disciplinaDTO);
        return ResponseEntity.status(201).body(disciplinaCreated);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaDTO getOne(@PathVariable @Positive Long id){
        return disciplinaService.getDisciplina(id);
    }

    @GetMapping("/listarDisciplinas")
    public ResponseEntity<List<Disciplina>> getAll(){
        return new ResponseEntity<>(disciplinaService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> updateDisciplina(@PathVariable @Positive Long id, @RequestBody @Validated Disciplina disciplinaAtt) {
        return new ResponseEntity<>(disciplinaService.updateDisciplina(id,disciplinaAtt),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAluno(@PathVariable @Positive Long id) {
        disciplinaService.deleteDisciplina(id);
    }
}
