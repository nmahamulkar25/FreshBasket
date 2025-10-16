import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product';
import url from './serverurl';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(url + "/products")
  }
  addProduct(ad: Product): Observable<Product> {
    return this.http.post<Product>(url + "/products", ad)
  }
  deleteProduct(id: any): Observable<any> {
    return this.http.delete(url + "/products/" + id)
  }
  updateProduct(id: any, ad: Product): Observable<Product> {
    return this.http.put<Product>(url + "/products/" + id, ad)
  }
  getProductById(id: any): Observable<Product> {
    return this.http.get<Product>(url + "/products/" + id)
  }
  getProductsByCategory(ca: any): Observable<Product[]> {
    return this.http.get<Product[]>(url + "/products/category" + ca)
  }
}
