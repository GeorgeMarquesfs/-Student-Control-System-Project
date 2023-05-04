package com.alunosprofessores.sistema.services.Impl;

import com.alunosprofessores.sistema.models.dtos.AlunoDto;
import com.alunosprofessores.sistema.exception.RecordNotFoundException;
import com.alunosprofessores.sistema.models.Aluno;
import com.alunosprofessores.sistema.repositorys.AlunoRepository;
import com.alunosprofessores.sistema.services.IAlunoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    AlunoRepository alunoRepository;


    public Aluno createAlunoService (AlunoDto alunoDTO){
        Aluno novoAluno = new Aluno();
        novoAluno.setNome(alunoDTO.getNome());
        novoAluno.setCelular(alunoDTO.getCelular());
        novoAluno.setDataNasc(alunoDTO.getDataNasc());
        novoAluno.setEmail(alunoDTO.getEmail());
        novoAluno.setCurso(alunoDTO.getCurso());
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
