import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Aluno } from '../../model/aluno';

@Component({
  selector: 'app-alunos-list',
  templateUrl: './alunos-list.component.html',
  styleUrls: ['./alunos-list.component.scss']
})
export class AlunosListComponent {

  @Input() alunos : Aluno[] = [];
  @Output() add = new EventEmitter(false)
  @Output() edit = new EventEmitter(false)
  @Output() delete = new EventEmitter(false)

  readonly displayedColumns = ['nome', 'matricula', 'dataNasc', 'curso', 'email' ,'actions']



  onAdd(){
    this.add.emit(true);
  }

  onEdit(element: Aluno){
    this.edit.emit(element);
  }

  onDelete(element: Aluno){
    this.delete.emit(element)
  }

}
