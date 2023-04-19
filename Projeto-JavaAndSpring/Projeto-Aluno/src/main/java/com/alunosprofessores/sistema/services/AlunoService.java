package com.alunosprofessores.sistema.services;

import com.alunosprofessores.sistema.dtos.AlunoForm;
import com.alunosprofessores.sistema.exception.RecordNotFoundException;
import com.alunosprofessores.sistema.models.Aluno;
import com.alunosprofessores.sistema.repositorys.AlunoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;


    public Aluno createAlunoService (AlunoForm alunoForm){
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(alunoForm.getNome());
        novoAluno.setMatricula(alunoForm.getMatricula());
        novoAluno.setDataNasc(alunoForm.getDataNasc());
        novoAluno.setEmail(alunoForm.getEmail());
        novoAluno.setCurso(alunoForm.getCurso());
        return alunoRepository.save(novoAluno);
    }

    public Aluno getAluno(Long id){
        return alunoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public List<Aluno> getAll(){
        return alunoRepository.findAll();
    }

    public Aluno updateAluno(Long id,Aluno alunoAtt){
        Aluno aluno = alunoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
        BeanUtils.copyProperties(alunoAtt, aluno, "id");
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return alunoAtualizado;
    }

    public void deleteAluno(Long id){
        alunoRepository.delete(alunoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
