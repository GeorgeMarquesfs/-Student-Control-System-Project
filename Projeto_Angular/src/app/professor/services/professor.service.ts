import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Professor } from '../../professor/model/professor';
import { first, delay, tap} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfessorService {

  private readonly API_GET = 'http://localhost:8080/api/professor/ListaProfessores';
  private readonly API = 'http://localhost:8080/api/professor';

  constructor(private httpClient: HttpClient) { }


  list(){
    return this.httpClient.get<Professor[]>(this.API_GET)
    .pipe(
      first(),
      delay(2000),
      tap(professor => console.log(professor))
    );
  }

  loadById(id: Number){
    return this.httpClient.get<Professor>(`${this.API}/${id}`);
  }

  save(record: Partial<Professor>){
    console.log(record)
    if(record.id){
      return this.update(record)
    }
    return this.create(record);
  }

  private create(record: Partial<Professor>){
    return this.httpClient.post<Professor>(this.API, record);
  }

  private update(record: Partial<Professor>){
    return this.httpClient.put<Professor>(`${this.API}/${record.id}`,record);
  }

  delete(id: Number){
    return this.httpClient.delete(`${this.API}/${id}`)
  }

}
