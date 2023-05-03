package com.alunosprofessores.sistema.services.Impl;

import com.alunosprofessores.sistema.exception.RecordNotFoundException;
import com.alunosprofessores.sistema.models.MatriculaAluno;
import com.alunosprofessores.sistema.models.StatusAluno;
import com.alunosprofessores.sistema.models.StatusMatricula;
import com.alunosprofessores.sistema.models.dtos.DisciplinaDto;
import com.alunosprofessores.sistema.models.dtos.DisicplinasAlunoDto;
import com.alunosprofessores.sistema.models.dtos.HistoricoAlunoDto;
import com.alunosprofessores.sistema.models.dtos.NotasAlunosDto;
import com.alunosprofessores.sistema.repositorys.MatriculaAlunoRepository;
import com.alunosprofessores.sistema.services.IMatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MatriculaAlunoImpl implements IMatriculaAlunoService {

    static final Double notaMedia = 7d;

    @Autowired
    MatriculaAlunoRepository matriculaAlunoRepository;

    @Override
    public MatriculaAluno create(MatriculaAluno matriculaALuno) {
        matriculaALuno.setStatusMatricula(StatusMatricula.MATRICULADO);
        matriculaALuno.setStatusAluno(StatusAluno.CURSANDO);
        matriculaALuno.setMatricula(matriculaALuno.gerarMatriculaAleatoria());
        return matriculaAlunoRepository.save(matriculaALuno);
    }

    @Override
    public MatriculaAluno getMatriculaAluno(Long id) {
        return matriculaAlunoRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    @Override
    public List<MatriculaAluno> getAll() {
        return matriculaAlunoRepository.findAll();
    }

    @Override
    public void updateMatricula(Long id){
        Optional<MatriculaAluno> matriculaAlunoUp = Optional.ofNullable(matriculaAlunoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));

        if(matriculaAlunoUp.isPresent()){
           if(matriculaAlunoUp.get().getStatusMatricula() == StatusMatricula.MATRICULADO){
               matriculaAlunoUp.get().setStatusMatricula(StatusMatricula.TRANCADO);
           } else {
               throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é possível trancar com status MATRICULADO.");
           }
        }
        matriculaAlunoRepository.save(matriculaAlunoUp.get());
    }

    @Override
    public MatriculaAluno updateNotasAluno(Long id, NotasAlunosDto notasAlunosDto) {
        Optional<MatriculaAluno> notasAlunoUp = Optional.ofNullable(matriculaAlunoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));

        if(notasAlunoUp.get().getStatusMatricula() == StatusMatricula.MATRICULADO){
            if(notasAlunoUp.get().getNota1() == null){
                notasAlunoUp.get().setNota1(notasAlunosDto.getNota1());
            }
            if(notasAlunoUp.get().getNota2() == null){
                notasAlunoUp.get().setNota2(notasAlunosDto.getNota2());
            }
            if (notasAlunoUp.get().getNota1() != null && notasAlunoUp.get().getNota2() != null){
                if((notasAlunoUp.get().getNota1() + notasAlunoUp.get().getNota2()) / 2 >= notaMedia){
                    notasAlunoUp.get().setStatusAluno(StatusAluno.APROVADO);
                } else {
                    notasAlunoUp.get().setStatusAluno(StatusAluno.REPROVADO);
                }
            }
            return matriculaAlunoRepository.save(notasAlunoUp.get());
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Só é possível colocar notas em alunos que estejam Matriculado");
        }
    }

    @Override
    public HistoricoAlunoDto historicoAluno(Long id) {
        List<MatriculaAluno> matriculasDoAluno = matriculaAlunoRepository.findAllById(Collections.singleton(id));

        if (!matriculasDoAluno.isEmpty()) {
            HistoricoAlunoDto historico = new HistoricoAlunoDto();

            historico.setAluno(matriculasDoAluno.get(0).getAluno().getNome());
            historico.setCurso(matriculasDoAluno.get(0).getAluno().getCurso());
            List<DisicplinasAlunoDto> disciplinasList = new ArrayList<>();
            for (MatriculaAluno matricula: matriculasDoAluno) {
                DisicplinasAlunoDto disciplinasAlunoDto = new DisicplinasAlunoDto();

                disciplinasAlunoDto.setNomeDisciplina(matricula.getDisciplina().getNome());
                disciplinasAlunoDto.setProfessorDisciplina(matricula.getDisciplina().getProfessor().getNome());
                disciplinasAlunoDto.setNota1(matricula.getNota1());
                disciplinasAlunoDto.setNota2(matricula.getNota2());
                if ((matricula.getNota1() != null && matricula.getNota2() != null)) {
                    disciplinasAlunoDto.setMedia((matricula.getNota1() + matricula.getNota2()) / 2);
                } else {
                    disciplinasAlunoDto.setMedia(null);
                }
                disciplinasAlunoDto.setStatusAluno(matricula.getStatusAluno());

                disciplinasList.add(disciplinasAlunoDto);
            }

            historico.setMatriculasDisciplinas(disciplinasList);

            return historico;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Esse aluno não possui matrículas.");
    }

    @Override
    public void deleteMatriculaAluno(Long id) {
        matriculaAlunoRepository.delete(matriculaAlunoRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }
}
