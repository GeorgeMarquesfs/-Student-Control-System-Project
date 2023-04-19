import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AlunosFormComponent } from './containers/alunos-form/alunos-form.component';
import { AlunosComponent } from './containers/alunos/alunos.component';
import { AlunoResolver } from './guards/aluno.resolver';


const routes: Routes = [
  { path: '', component: AlunosComponent},
  { path: 'newStudent', component: AlunosFormComponent, resolve:{ aluno: AlunoResolver}},
  { path: 'editStudent/:id', component: AlunosFormComponent, resolve:{ aluno: AlunoResolver}}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AlunosRoutingModule { }
