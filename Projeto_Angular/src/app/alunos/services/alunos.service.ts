import { Aluno } from './../model/aluno';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { first, delay, tap} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AlunosService {

  private readonly API_GET = 'http://localhost:8080/api/aluno/ListarAlunos';
  private readonly API = 'http://localhost:8080/api/aluno';


  constructor(private httpClient: HttpClient) { }


  list(){
    return this.httpClient.get<Aluno[]>(this.API_GET)
    .pipe(
      first(),
      delay(2000),
      tap(aluno => console.log(aluno))
    );
  }

  loadById(id: Number){
    return this.httpClient.get<Aluno>(`${this.API}/${id}`);
  }

  save(record: Partial<Aluno>){
    console.log(record)
    if(record.id){
      return this.update(record)
    }
    return this.create(record);
  }

  private create(record: Partial<Aluno>){
    return this.httpClient.post<Aluno>(this.API, record);
  }

  private update(record: Partial<Aluno>){
    return this.httpClient.put<Aluno>(`${this.API}/${record.id}`,record);
  }

  delete(id: Number){
    return this.httpClient.delete(`${this.API}/${id}`)
  }



}
