import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../shared/app-material/app-material.module';
import { SharedModule } from '../shared/shared.module';
import { AlunosRoutingModule } from './alunos-routing.module';
import { AlunosListComponent } from './components/alunos-list/alunos-list.component';
import { AlunosFormComponent } from './containers/alunos-form/alunos-form.component';
import { AlunosComponent } from './containers/alunos/alunos.component';



@NgModule({
  declarations: [
    AlunosComponent,
    AlunosFormComponent,
    AlunosListComponent,

  ],
  imports: [
    CommonModule,
    AlunosRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule

  ]
})
export class AlunosModule { }
