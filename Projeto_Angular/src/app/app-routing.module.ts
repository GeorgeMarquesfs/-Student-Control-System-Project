import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home/home.component';



const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'alunos', loadChildren: () => import('./alunos/alunos.module').then(m => m.AlunosModule)},
  { path: 'professor', loadChildren: () => import('./professor/professor.module').then(m => m.ProfessorModule)},
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
