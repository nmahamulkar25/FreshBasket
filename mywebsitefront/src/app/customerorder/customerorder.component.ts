import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-customerorder',
  standalone: true,
  imports: [CommonModule, FormsModule,RouterLink],
  templateUrl: './customerorder.component.html',
  styleUrls: ['./customerorder.component.css']
})
export class CustomerOrderComponent {
 parr:Product[]=[]

  constructor(private rs:ProductService,private router: Router){}
  ngOnInit():void{
     this.loadProducts();
    this.rs.getAllProducts().subscribe(data=>
    {
      if(data.length>0)
        this.parr=data
    }
    )
  }
  loadProducts(): void {
    this.rs.getAllProducts().subscribe(data => {
      this.parr = data;
    });
  }

  
  onDelete(id: number): void {
    if (confirm('Are you sure you want to delete this product?')) {
      this.rs.deleteProduct(id).subscribe(() => {
        alert('Product deleted successfully!');
        this.loadProducts(); 
      });
    }
  }

  

}
