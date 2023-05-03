import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { FormControl, NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { AlunosService } from '../../services/alunos.service';
import { Aluno } from './../../model/aluno';




@Component({
  selector: 'app-alunos-form',
  templateUrl: './alunos-form.component.html',
  styleUrls: ['./alunos-form.component.scss']
})
export class AlunosFormComponent {

  dataNasc = new FormControl<Date | string | null>(null);

  form = this.formBuilder.group({
    id:[0],
    nome: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(100)]],
    matricula: ['', Validators.required],
    dataNasc: this.dataNasc,
    curso: ['', Validators.required],
    email:['',[Validators.required, Validators.email]]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: AlunosService,
    private _snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute
  ){
    const aluno: Aluno = this.route.snapshot.data['aluno'];
    if (aluno.id != null) {
      this.form.patchValue({
        id: aluno.id,
        nome: aluno.nome,
        matricula: aluno.matricula,
        dataNasc: aluno.dataNasc,
        curso: aluno.curso,
        email: aluno.email
      })
    } else {
      this.form.patchValue({
        nome: aluno.nome,
        matricula: aluno.matricula,
        dataNasc: aluno.dataNasc,
        curso: aluno.curso,
        email: aluno.email
      })
    }
  }

  onSubmit(){
    const formValue = this.form.value;
    if (formValue.dataNasc instanceof Date) {
      formValue.dataNasc = formValue.dataNasc.toISOString();
    }
    this.service.save(formValue).subscribe(result => this.onSucess(), error => this.onError());
  }

  onCancel(){
    this.location.back();
  }

  private onSucess(){
    this._snackBar.open('Aluno salvo com sucesso!', '',{
      duration:3000})
      this.onCancel();
  }

  private onError(){
    this._snackBar.open('Error ao salvar aluno', '',{
      duration:3000
    })
  }


  getErrorMessage(fieldName:string){
    const field = this.form.get(fieldName)

    if(field?.hasError('required')){
      return 'Campo obrigatório'
    }
    if(field?.hasError('minlength')){
      const requiredLength = field.errors ? field.errors['minlength']['requiredLength'] : 5;
      return `Tamanho mínimo precisa ser de ${requiredLength} caracteres. `
    }
    if(field?.hasError('maxlength')){
      const requiredLength = field.errors ? field.errors['maxlength']['requiredLength'] : 200;
      return `Tamanho máximo excedido de ${requiredLength} caracteres. `
    }
    if(field?.hasError('email')){
      return 'ex: exemplo@hotmail.com'
    }
    if(field?.hasError('dataNasc')){
      return 'Use o formato: yyyy-MM-dd'
    }
    return 'Campo inválido'
  }





}
