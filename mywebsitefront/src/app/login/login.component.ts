import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Router } from '@angular/router';
import { Register } from '../model/register';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, RouterModule],  // <-- add RouterModule here
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  reg: Register = new Register();

  constructor(private rs: RegisterService, private router: Router) { }

  submitdata() {
    this.rs.login(this.reg.email, this.reg.password).subscribe(data => {
      if (data.length > 0) {
        alert("Login Successful");
        localStorage.setItem("cemail", this.reg.email);
        localStorage.setItem("cname", data[0].username);
        this.router.navigate(['/']);  // redirect to home after login
      } else {
        alert("Invalid user");
      }
    });
  }
}