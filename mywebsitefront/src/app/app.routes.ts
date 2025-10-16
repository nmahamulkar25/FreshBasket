import { Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';

import { LoginComponent } from './login/login.component';


import { UserComponent } from './user/user.component';
import { CartComponent } from './cart/cart.component';


import { RegisterComponent } from './register/register.component';

import { DisplaypageComponent } from './displaypage/displaypage.component';
import { AdminLoginComponent } from './adminlogin/adminlogin.component';
import { CustomerOrderComponent } from './customerorder/customerorder.component';
import { ProductComponent } from './product/product.component';
import { ViewregComponent } from './viewreg/viewreg.component';


export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'viewreg', component: ViewregComponent},
  { path: 'user', component: UserComponent },
  { path: 'cart', component: CartComponent },
 
  { path: 'adminlogin', component: AdminLoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'displaypage/:category', component: DisplaypageComponent },
  { path: 'customerorder', component: CustomerOrderComponent },
  { path: 'product', component: ProductComponent },
  { path: 'login', component: LoginComponent }

];