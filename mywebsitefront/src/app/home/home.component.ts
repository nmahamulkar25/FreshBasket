import { Component, OnInit } from '@angular/core';
import { Router, RouterLink, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { Product } from '../model/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, RouterModule,RouterLink],  // ✅ add RouterModule here
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit{
parr:Product[]=[]
cemail=localStorage.getItem('cemail')
constructor(private ps:ProductService,private router:Router){}
ngOnInit(): void {
  this.ps.getAllProducts().subscribe(data=>
  {
    if(data.length>0)
    {
      this.parr=data
      console.log(this.parr)
    }
  }
  )
}
viewcart(iname:any)
{
this.router.navigate(["/cart",iname])
}
showproducts(productname:any)
{
  this.parr=this.parr.filter(p=>p.category==productname)
}

}
