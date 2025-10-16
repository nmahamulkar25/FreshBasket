import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  usertype = "guest"
  constructor(private router: Router) {

  }
  ngOnInit(): void {
    this.router.events.subscribe((val: any) => {
      if (val.url) {
        var cemail = localStorage.getItem("cemail")
        if (cemail !== null) {
          this.usertype = "user"
        }
        else {
          var aemail=localStorage.getItem("aemail")
          if(aemail!=null)
          {
            this.usertype= "Admin"
          }
          else
          {
          this.usertype = "guest"
          }
        }
      }
    })
    {

    }
  }
  clogout()
  {
    localStorage.removeItem("cemail")
    this.router.navigate(["/"])
    alert("Are you sure you want to logout ?")
  }
  alogout()
  {
    localStorage.removeItem("aemail")
    this.router.navigate(["/"])
    alert("Are you sure you want to logout ?")
  }
}
