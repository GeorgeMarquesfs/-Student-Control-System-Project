package com.alunosprofessores.sistema.controllers;

import com.alunosprofessores.sistema.models.Disciplina;
import com.alunosprofessores.sistema.models.dtos.ProfessorDto;
import com.alunosprofessores.sistema.models.Professor;
import com.alunosprofessores.sistema.services.Impl.ProfessorServiceImpl;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/professor")
@CrossOrigin(origins = "*")
public class ProfessorController {


    @Autowired
    ProfessorServiceImpl professorServiceImpl;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Professor> createProf(@Validated @RequestBody ProfessorDto professorDTO) {
        Professor profNew = professorServiceImpl.createProf(professorDTO);
        return ResponseEntity.status(201).body(profNew);
    }

    @GetMapping("/{id}")
    public Professor getProf(@PathVariable Long id) {
        return professorServiceImpl.getProfessor(id);
    }

    @GetMapping("/listarDisciplinasProf/{id}")
    public List<Disciplina> getOnlyDisciplinasProfessor(@PathVariable Long id) {
        return professorServiceImpl.getOnlyDisciplinasProfessor(id);
    }

    @GetMapping("/ListaProfessores")
    public ResponseEntity<List<Professor>> getAllProf() {
        return new ResponseEntity<>(professorServiceImpl.getAllProf(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable @Positive Long id, @RequestBody @Validated ProfessorDto professorAtt){
        return new ResponseEntity<>(professorServiceImpl.updateProfessor(id,professorAtt),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProf(@PathVariable @Positive Long id){
        professorServiceImpl.deleteProf(id);
    }

}
