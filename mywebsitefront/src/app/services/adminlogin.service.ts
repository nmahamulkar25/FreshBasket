import { Injectable } from '@angular/core';
import url from './serverurl';
import serverurl from './serverurl';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Adminlogin } from '../model/adminlogin';
@Injectable({
  providedIn: 'root'
})
export class AdminloginService {

  constructor(private http: HttpClient) { }

  getAllAdmins(): Observable<Adminlogin[]> {
    return this.http.get<Adminlogin[]>(url + "/admins")
  }
  addAdmin(ad: Adminlogin): Observable<Adminlogin> {
    return this.http.post<Adminlogin>(url + "/admins", ad)
  }
  deleteAdmin(id: any): Observable<any> {
    return this.http.delete(url + "/admins/" + id)
  }
  updateAdmin(id: any, ad: Adminlogin): Observable<Adminlogin> {
    return this.http.put<Adminlogin>(url + "/admins/" + id, ad)
  }
  getAdminById(id: any): Observable<Adminlogin> {
    return this.http.get<Adminlogin>(url + "/admins/" + id)
  }
  login(em: any, ps: any): Observable<Adminlogin[]> {
    return this.http.get<Adminlogin[]>(url + "/admins/login/" + em + "/" + ps)
  }
}
