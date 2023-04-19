package com.alunosprofessores.sistema.controllers;

import com.alunosprofessores.sistema.dtos.ProfessorForm;
import com.alunosprofessores.sistema.models.Professor;
import com.alunosprofessores.sistema.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {


    @Autowired
    ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Professor> createProf(@Validated @RequestBody ProfessorForm professorForm) {
        Professor profNew = professorService.createProf(professorForm);
        return ResponseEntity.status(201).body(profNew);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProf(@PathVariable Long id) {
        Optional<Professor> professor = professorService.getProfessor(id);
        if(professor.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(professor.get(),HttpStatus.OK);
    }

    @GetMapping("/ListaProfessores")
    public ResponseEntity<List<Professor>> getAllProf() {
        return new ResponseEntity<>(professorService.getAllProf(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody ProfessorForm professorAtt){
        return new ResponseEntity<>(professorService.updateProfessor(id,professorAtt),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProf(@PathVariable Long id){
        Optional<Professor> professor = professorService.getProfessor(id);
        if(professor.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        professorService.deleteProf(professor.get().getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
