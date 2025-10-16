import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';  // <-- add this
import { Register } from '../model/register';
import { RegisterService } from '../services/register.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterModule],  // <-- add RouterModule
  templateUrl: './register.component.html',
})
export class RegisterComponent {
  reg: Register = new Register();

  constructor(private rs: RegisterService) {}

  submitdata() {
    this.rs.addem(this.reg).subscribe((data) => {
      if (data != null) {
        alert('Registration Successful');
      }
    });
  }
}