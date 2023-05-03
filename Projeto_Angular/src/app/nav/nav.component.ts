import { Component, EventEmitter, Output } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent {

  constructor(private router: Router) { }

  @Output() professor = new EventEmitter(false)

  onProfessor(){
    this.router.navigate(['/professor']);
  }

  onAluno(){
    this.router.navigate(['/alunos']);
  }

  onHome(){
    this.router.navigate(['/home']);
  }


}
