import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { Cart } from '../model/cart';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartItems: Cart[] = [];


  constructor(
    private route: ActivatedRoute,
    private cartService: CartService,
    private router: Router,
    private registerService: RegisterService
  ) {}

  ngOnInit(): void {

    // Load cart items
    this.cartItems = this.cartService.getLocalCartItems();

    
  }

  removeItem(index: number): void {
    this.cartService.removeLocalCartItem(index);
    this.cartItems = this.cartService.getLocalCartItems();
  }

  onClick(): void {
    alert('Order Placed Successfully!');
    this.cartService.clearLocalCart();
    this.router.navigate(['/']);
  }

  get totalAmount(): number {
    return this.cartItems.reduce(
      (sum, item) => sum + item.price,
      0
    );
  }
}
