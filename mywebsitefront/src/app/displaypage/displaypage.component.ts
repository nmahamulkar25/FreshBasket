import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router} from '@angular/router';
import { CommonModule } from '@angular/common';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';
import { CartService } from '../services/cart.service'; 
import { Cart } from '../model/cart';
@Component({
  selector: 'app-displaypage',
  standalone: true,
  imports: [ CommonModule],
  templateUrl: './displaypage.component.html',
  styleUrls: ['./displaypage.component.css']
})
export class DisplaypageComponent implements OnInit {
  parr: Product[] = []
  cemail = localStorage.getItem('cemail')
  category: string = ''

  constructor(private ps: ProductService,private route: ActivatedRoute,private router: Router,private cartService: CartService ) 
  {

  }

  ngOnInit(): void {
    this.category = this.route.snapshot.paramMap.get('category') || ''
    
    this.ps.getAllProducts().subscribe((data: any) => {
      if (data.length > 0)
         {
       
        this.parr = data.filter((p: Product) => p.category === this.category)
        console.log(this.parr)
      }
    })
  }

  viewcart(p: Product) {
  const cartItem: Cart = {
    productname: p.productname,

    price: p.price,
    imageurl: p.imageurl,
    total: p.price
  };

  this.cartService.addToLocalCart(cartItem);
  alert(`${p.productname} added to cart! 🛒`);
}

selectedProduct: any = null;

openProduct(product: any) {
  this.selectedProduct = product;
}

closeProduct() {
  this.selectedProduct = null;
}
}
