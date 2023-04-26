package com.alunosprofessores.sistema.controllers;

import com.alunosprofessores.sistema.dtos.ProfessorDTO;
import com.alunosprofessores.sistema.models.Professor;
import com.alunosprofessores.sistema.services.ProfessorService;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/professor")
@CrossOrigin(origins = "*")
public class ProfessorController {


    @Autowired
    ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Professor> createProf(@Validated @RequestBody ProfessorDTO professorDTO) {
        Professor profNew = professorService.createProf(professorDTO);
        return ResponseEntity.status(201).body(profNew);
    }

    @GetMapping("/{id}")
    public Professor getProf(@PathVariable Long id) {
        return professorService.getProfessor(id);
    }

    @GetMapping("/ListaProfessores")
    public ResponseEntity<List<Professor>> getAllProf() {
        return new ResponseEntity<>(professorService.getAllProf(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable @Positive Long id, @RequestBody @Validated ProfessorDTO professorAtt){
        return new ResponseEntity<>(professorService.updateProfessor(id,professorAtt),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProf(@PathVariable @Positive Long id){
        professorService.deleteProf(id);
    }

}
