package com.alunosprofessores.sistema.controllers;

import com.alunosprofessores.sistema.models.dtos.DisciplinaDto;
import com.alunosprofessores.sistema.models.Disciplina;
import com.alunosprofessores.sistema.services.Impl.DisciplinaServiceImpl;
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
    DisciplinaServiceImpl disciplinaServiceImpl;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public DisciplinaDto getOne(@PathVariable @Positive Long id){
        return disciplinaServiceImpl.getDisciplina(id);
    }

    @GetMapping("/listarDisciplinas")
    public ResponseEntity<List<Disciplina>> getAll(){
        return new ResponseEntity<>(disciplinaServiceImpl.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> updateDisciplina(@PathVariable @Positive Long id, @RequestBody @Validated Disciplina disciplinaAtt) {
        return new ResponseEntity<>(disciplinaServiceImpl.updateDisciplina(id,disciplinaAtt),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAluno(@PathVariable @Positive Long id) {
        disciplinaServiceImpl.deleteDisciplina(id);
    }
}
