import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import url from './serverurl';
import { Customerorder } from '../model/customerorder';

@Injectable({
  providedIn: 'root'
})
export class CustomerorderService {

  constructor(private http: HttpClient) { }

  getAllOrders(): Observable<Customerorder[]> {
    return this.http.get<Customerorder[]>(url + "/orders")
  }
  addOrder(ad: Customerorder): Observable<Customerorder> {
    return this.http.post<Customerorder>(url + "/orders", ad)
  }
  deleteOrder(id: any): Observable<any> {
    return this.http.delete(url + "/orders/" + id)
  }
  updateOrder(id: any, ad: Customerorder): Observable<Customerorder> {
    return this.http.put<Customerorder>(url + "/orders/" + id, ad)
  }
  getOrderById(id: any): Observable<Customerorder> {
    return this.http.get<Customerorder>(url + "/orders/" + id)
  }
  getOrdersByEmail(em: any): Observable<Customerorder[]> {
    return this.http.get<Customerorder[]>(url + "/orders/" + em)
  }
}
