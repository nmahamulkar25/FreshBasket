import { Component } from '@angular/core';
import { RegisterService } from '../services/register.service';
import { Register } from '../model/register';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-viewreg',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './viewreg.component.html',
  styleUrl: './viewreg.component.css'
})
export class ViewregComponent {

  rarr: Register[] = [];

  constructor(private rs: RegisterService) {}

  ngOnInit(): void {
    this.rs.getallemps().subscribe((data: any) => {
      if (data.length > 0) {
        this.rarr = data;
      }
    });
  }
}
