import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { Cart } from '../model/cart';
@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  [x: string]: any;
  product: any = {};
  cartItems: Cart[] = [];   
  constructor(private route: ActivatedRoute,private cartService: CartService,private router:Router ) {}

 ngOnInit(): void {
  this.cartItems = this.cartService.getLocalCartItems();
}

removeItem(i: number) {
  this.cartService.removeLocalCartItem(i);
  this.cartItems = this.cartService.getLocalCartItems();
}
onClick()
{
  alert("Order Placed Successfully !")
  this.cartService.clearLocalCart()
  this.router.navigate(["/"])
}
}
