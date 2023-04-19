import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { ErrorDialogComponent } from 'src/app/shared/components/error-dialog/error-dialog.component';

import { AlunosService } from '../../services/alunos.service';
import { Aluno } from './../../model/aluno';
import { ConfirmationDialogComponent } from 'src/app/shared/components/confirmation-dialog/confirmation-dialog.component';

@Component({
  selector: 'app-alunos',
  templateUrl: './alunos.component.html',
  styleUrls: ['./alunos.component.scss'],
})
export class AlunosComponent {
  alunos$: Observable<Aluno[]> | null = null;

  // Tratamento de Erros fica aqui
  constructor(
    private alunosService: AlunosService,
    public dialog: MatDialog,
    private router: Router,
    private snackBar: MatSnackBar,
  ) {
    this.refresh();
  }

  onAdd() {
    this.router.navigate(['alunos/newStudent']);
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  onEdit(aluno: Aluno) {
    this.router.navigate(['alunos/editStudent', aluno.id]);
  }

  refresh() {
    this.alunos$ = this.alunosService.list().pipe(
      catchError((error) => {
        this.onError('Erro ao carregar os alunos!');
        return of([]);
      })
    );
  }

  onDelete(aluno: Aluno) {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      data: 'Tem certeza que deseja remover esse curso ?',
    });

    dialogRef.afterClosed().subscribe((result: boolean) => {
      if (result) {
        this.alunosService.delete(aluno.id ?? 0).subscribe(
          () => {
            this.refresh();
            this.snackBar.open('Aluno(a) removido com sucesso', 'X', {
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
