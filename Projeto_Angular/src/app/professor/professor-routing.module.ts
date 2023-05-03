import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProfessorFormComponent } from './containers/professor-form/professor-form.component';
import { ProfessorComponent } from './containers/professor/professor.component';
import { ProfessorResolver } from './guards/professor.resolver';


const routes: Routes = [
  { path: '', component: ProfessorComponent},
  { path: 'newProfessor', component: ProfessorFormComponent, resolve:{ professor: ProfessorResolver}},
  { path: 'editProfessor/:id', component: ProfessorFormComponent, resolve:{ professor: ProfessorResolver}}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfessorRoutingModule { }
