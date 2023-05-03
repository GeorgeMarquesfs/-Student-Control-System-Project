import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { ProfessorService } from '../../professor/services/professor.service';
import { Professor } from './../model/professor';


@Injectable({
  providedIn: 'root'
})
export class ProfessorResolver implements Resolve<Professor> {

  constructor( private service: ProfessorService){}


  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Professor> {
    if(route.params && route.params['id']){
      return this.service.loadById(route.params['id']);
    }
    return of({nome: '', email:''});
  }
}
