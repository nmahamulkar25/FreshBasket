import { Component, OnInit } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';
import { Cart } from '../model/cart';
import { CartService } from '../services/cart.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  
  parr: Product[] = [];


  groupedProducts: { [category: string]: Product[] } = {};

  cemail = localStorage.getItem('cemail');

  constructor(private ps: ProductService, private router: Router,private cartService: CartService ) {}

  ngOnInit(): void {
    this.loadProducts();
  }

  // ✅ Fetch all products and group by category
  loadProducts(): void {
    this.ps.getAllProducts().subscribe({
      next: (data: any) => {
        if (data && data.length > 0) {
          this.parr = data;
          this.groupProductsByCategory();
        }
      },
      error: (err: any) => console.error('Error loading products:', err)
    });
  }

  // ✅ Group products by category
  groupProductsByCategory(): void {
    this.groupedProducts = {};
    this.parr.forEach((product) => {
      const category = product.category || 'Others';
      if (!this.groupedProducts[category]) {
        this.groupedProducts[category] = [];
      }
      this.groupedProducts[category].push(product);
    });
  }

  
  viewAll(category: string): void {
    this.router.navigate(['/displaypage', category]);
  }
  viewcart(p: Product) {
    const cartItem: Cart = {
      productname: p.productname,
  
      price: p.price,
      imageurl: p.imageurl,
      total: undefined
    };
  
    this.cartService.addToLocalCart(cartItem);
    alert(`${p.productname} added to cart! 🛒`);
  }
}
