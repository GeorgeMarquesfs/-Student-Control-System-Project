package com.alunosprofessores.sistema.services.Impl;

import com.alunosprofessores.sistema.models.Disciplina;
import com.alunosprofessores.sistema.models.dtos.DisciplinaDto;
import com.alunosprofessores.sistema.models.dtos.ProfessorDto;
import com.alunosprofessores.sistema.exception.RecordNotFoundException;
import com.alunosprofessores.sistema.models.Professor;
import com.alunosprofessores.sistema.repositorys.DisciplinaRepository;
import com.alunosprofessores.sistema.repositorys.ProfessorRepository;
import com.alunosprofessores.sistema.services.IProfessorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements IProfessorService {

    @Autowired
    ProfessorRepository professorRepository;


    public Professor createProf(ProfessorDto professorDTO){
        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setEmail(professorDTO.getEmail());

        List<Disciplina> disciplinas = new ArrayList<>();
        for (Disciplina disciplinaDTO : professorDTO.getDisciplinas()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setNome(disciplinaDTO.getNome());
            disciplina.setCargaHoraria(disciplinaDTO.getCargaHoraria());
            disciplina.setProfessor(professor);
            disciplinas.add(disciplina);
        }

        professor.setDisciplinas(disciplinas);
        return professorRepository.save(professor);
    }

    public Professor getProfessor(Long id){
        return professorRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public List<Professor> getAllProf(){
        return professorRepository.findAll();
    }

    public Professor updateProfessor(Long id, ProfessorDto professorAtt){
        Optional<Professor> professor = Optional.of(professorRepository.getReferenceById(id));
        BeanUtils.copyProperties(professorAtt, professor.get(), "id");
        Professor professorAtualizado = professorRepository.save(professor.get());
        return professorAtualizado;

    }
    public void deleteProf(Long id){
        professorRepository.delete(professorRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

}
