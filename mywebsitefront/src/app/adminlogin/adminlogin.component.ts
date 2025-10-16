import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Adminlogin } from '../model/adminlogin';
import { AdminloginService } from '../services/adminlogin.service';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  standalone: true,
  imports: [CommonModule, FormsModule,RouterModule],
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminLoginComponent {
adm:Adminlogin=new Adminlogin()
constructor(private ads:AdminloginService,private router:Router){}
submitdata() {
    this.ads.login(this.adm.email, this.adm.password).subscribe(data => {
      if (data.length > 0) {
        alert("Login Successful");
        localStorage.setItem("aemail", this.adm.email);
        
        this.router.navigate(['/']);  // redirect to home after login
      } else {
        alert("Invalid user");
      }
    });
  }
}
