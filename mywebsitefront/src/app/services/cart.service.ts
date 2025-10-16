import { Injectable } from '@angular/core';
import url from './serverurl';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cart } from '../model/cart';

@Injectable({
  providedIn: 'root'
})
export class CartService {
private localCart: Cart[] = []; 
  constructor(private http: HttpClient) {const stored = localStorage.getItem('localCart');
    if (stored) {
      this.localCart = JSON.parse(stored);
    }
  }

  // ---------------- Local Cart Methods ----------------

  addToLocalCart(item: Cart) {
    this.localCart.push(item);
    localStorage.setItem('localCart', JSON.stringify(this.localCart));
  }

  getLocalCartItems(): Cart[] {
    return this.localCart;
  }

  removeLocalCartItem(index: number) {
    this.localCart.splice(index, 1);
    localStorage.setItem('localCart', JSON.stringify(this.localCart));
  }

  clearLocalCart() {
    this.localCart = [];
    localStorage.removeItem('localCart');
  } 




  

  getAllCartItems(): Observable<Cart[]> {
    return this.http.get<Cart[]>(url + "/carts")
  }

  addCartItem(ad: Cart): Observable<Cart> {
    return this.http.post<Cart>(url + "/carts", ad)
  }
  deleteCartItem(id: any): Observable<any> {
    return this.http.delete(url + "/carts/" + id)
  }
  updateCartItem(id: any, ad: Cart): Observable<Cart> {
    return this.http.put<Cart>(url + "/carts/" + id, ad)
  }
  getCartItemById(id: any): Observable<Cart> {
    return this.http.get<Cart>(url + "/carts/" + id)
  }
  getCartItemsByEmail(em: any): Observable<Cart[]> {
    return this.http.get<Cart[]>(url + "/carts/" + em)
  }
}
