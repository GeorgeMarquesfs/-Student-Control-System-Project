import { Location } from '@angular/common';
import { Component } from '@angular/core';
import { NonNullableFormBuilder, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { Professor } from '../../model/professor';
import { ProfessorService } from '../../services/professor.service';

@Component({
  selector: 'app-professor-form',
  templateUrl: './professor-form.component.html',
  styleUrls: ['./professor-form.component.scss']
})
export class ProfessorFormComponent {

  form = this.formBuilder.group({
    id:[0],
    nome: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(100)]],
    email:['',[Validators.required, Validators.email]]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: ProfessorService,
    private _snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute
  ){
    const professor: Professor | undefined = this.route.snapshot.data['professor'];
    if (professor) {
      if (professor.id != null) {
        this.form.patchValue({
          id: professor.id,
          nome: professor.nome,
          email: professor.email
        })
      } else {
        this.form.patchValue({
          nome: professor.nome,
          email: professor.email
        })
      }
    }
  }

  onSubmit(){
    const formValue = this.form.value;
    this.service.save(formValue).subscribe(result => this.onSucess(), error => this.onError());
  }

  onCancel(){
    this.location.back();
  }

  private onSucess(){
    this._snackBar.open('Professor salvo com sucesso!', '',{
      duration:3000})
      this.onCancel();
  }

  private onError(){
    this._snackBar.open('Error ao salvar professor', '',{
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
    return 'Campo inválido'
  }

}
