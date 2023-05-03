import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { Professor } from '../../model/professor';
import { ProfessorService } from '../../services/professor.service';


@Component({
  selector: 'app-professor',
  templateUrl: './professor.component.html',
  styleUrls: ['./professor.component.scss']
})
export class ProfessorComponent {

  professor$: Observable<Professor[]> | null = null;

  // Tratamento de Erros fica aqui
  constructor(
    private professorService: ProfessorService,
    public dialog: MatDialog,
    private router: Router,
    private snackBar: MatSnackBar,
  ) {
    this.refresh();
  }

  onAdd() {
    this.router.navigate(['professor/newProfessor']);
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  onEdit(professor: Professor) {
    this.router.navigate(['professor/editProfessor', professor.id]);
  }

  refresh() {
    this.professor$ = this.professorService.list().pipe(
      catchError((error) => {
        this.onError('Erro ao carregar os professores!');
        return of([]);
      })
    );
  }

  onDelete(professor: Professor) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem certeza que deseja remover esse professor(a) ?',
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {
        this.professorService.delete(professor.id ?? 0).subscribe(
          () => {
            this.refresh();
            this.snackBar.open('Professor(a) removido com sucesso', 'X', {
              duration: 3000,
              verticalPosition: 'top',
              horizontalPosition: 'center',
            });
          },
          (error) => this.onError('Erro ao tentar remover curso')
        );
      }
    });
  }
}
