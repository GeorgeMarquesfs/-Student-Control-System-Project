package com.alunosprofessores.sistema.services;

import com.alunosprofessores.sistema.dtos.DisciplinaDTO;
import com.alunosprofessores.sistema.exception.RecordNotFoundException;
import com.alunosprofessores.sistema.models.Disciplina;
import com.alunosprofessores.sistema.models.Professor;
import com.alunosprofessores.sistema.repositorys.DisciplinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository disciplinaRepository;

    @Autowired
    private ProfessorService professorService;


    public Disciplina create(DisciplinaDTO disciplinaDTO){
        Disciplina disciplinaNew = new Disciplina();
        disciplinaNew.setNome(disciplinaDTO.getNome());
        disciplinaNew.setCargaHoraria(disciplinaDTO.getCargaHoraria());
        disciplinaNew.setProfessor(disciplinaDTO.getProfessor());
        return disciplinaRepository.save(disciplinaNew);
    }

    public DisciplinaDTO getDisciplina(Long id){
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));

        Professor professor = professorService.getProfessor(disciplina.getProfessor().getId());

        return new DisciplinaDTO(
                disciplina.getNome(),
                disciplina.getCargaHoraria(),
                professor
        );
    }

    public List<Disciplina> getAll(){
        return disciplinaRepository.findAll();
    }

    public Disciplina updateDisciplina(Long id, Disciplina disciplinaAtt){
        Disciplina disciplina = disciplinaRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        BeanUtils.copyProperties(disciplinaAtt, disciplina, "id");
        Disciplina disciplinaAtualizada = disciplinaRepository.save(disciplina);
        return disciplinaAtualizada;
    }

    public void deleteDisciplina(Long id){
        disciplinaRepository.delete(disciplinaRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
