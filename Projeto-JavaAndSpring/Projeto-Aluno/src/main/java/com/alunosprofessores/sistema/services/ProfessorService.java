package com.alunosprofessores.sistema.services;

import com.alunosprofessores.sistema.dtos.ProfessorForm;
import com.alunosprofessores.sistema.models.Professor;
import com.alunosprofessores.sistema.repositorys.ProfessorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;


    public Professor createProf(ProfessorForm professorForm){
        Professor profNew = new Professor();
        profNew.setNome(professorForm.getNome());
        profNew.setListaCadeirasFacul(professorForm.getListaCadeirasFacul());
        return professorRepository.save(profNew);
    }

    public Optional<Professor> getProfessor(Long id){
        return professorRepository.findById(id);
    }

    public List<Professor> getAllProf(){
        return professorRepository.findAll();
    }

    public Professor updateProfessor(Long id, ProfessorForm professorAtt){
        Optional<Professor> professor = Optional.of(professorRepository.getReferenceById(id));
        BeanUtils.copyProperties(professorAtt, professor.get(), "id");
        Professor professorAtualizado = professorRepository.save(professor.get());
        return professorAtualizado;

    }
    public void deleteProf(Long id){
        professorRepository.deleteById(id);
    }
}
