import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  pro: Product = new Product()


  constructor(private cs: ProductService,private router: Router) {
    
  }

 onSubmit() {
  this.pro.price = Number(this.pro.price);
  console.log('Submitting product:', this.pro);
  this.cs.addProduct(this.pro).subscribe({
    next: (data: any) => alert('Product Added Successfully'),
error: (err: any) => console.error(err)
});
}
}
