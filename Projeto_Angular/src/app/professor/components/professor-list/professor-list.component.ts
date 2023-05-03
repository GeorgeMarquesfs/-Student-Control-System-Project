import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Professor } from '../../model/professor';

@Component({
  selector: 'app-professor-list',
  templateUrl: './professor-list.component.html',
  styleUrls: ['./professor-list.component.scss']
})
export class ProfessorListComponent {

  @Input() professor: Professor[] = [];
  @Output() add = new EventEmitter(false)
  @Output() edit = new EventEmitter(false)
  @Output() delete = new EventEmitter(false)

  readonly displayedColumns = ['nome', 'email' ,'actions']

  onAdd(){
    this.add.emit(true);
  }

  onEdit(element: Professor){
    this.edit.emit(element);
  }

  onDelete(element: Professor){
    this.delete.emit(element)
  }

}
