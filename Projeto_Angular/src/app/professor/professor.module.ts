import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { ProfessorRoutingModule } from '../professor/professor-routing.module';
import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { ProfessorListComponent } from './components/professor-list/professor-list.component';
import { ProfessorFormComponent } from './containers/professor-form/professor-form.component';
import { ProfessorComponent } from './containers/professor/professor.component';



@NgModule({
  declarations: [
    ProfessorComponent,
    ProfessorListComponent,
    ProfessorFormComponent
  ],
  imports: [
    CommonModule,
    ProfessorRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule

  ]
})
export class ProfessorModule { }
