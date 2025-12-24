import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Register } from '../model/register';
import url from './serverurl';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  getallemps(): Observable<Register[]> {
    return this.http.get<Register[]>(url + "/registers")
  }
  addem(ad: Register): Observable<Register> {
    return this.http.post<Register>(url + "/registers", ad)
  }
  del(id: any): Observable<any> {
    return this.http.delete(url + "/registers/" + id)
  }
  update(id: any, ad: Register): Observable<Register> {
    return this.http.put<Register>(url + "/registers/" + id, ad)
  }
  search(id: any): Observable<Register> {
    return this.http.get<Register>(url + "/registers/" + id)
  }
  login(em: any, ps: any): Observable<Register[]> {
    return this.http.get<Register[]>(url + "/registers/" + em + "/" + ps)
  }
  searchbyemail(em: any): Observable<Register> {
    return this.http.get<Register>(url + "/registers/" + em)
  }
  

}
