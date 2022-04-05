import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { CartproductlistComponent } from './cartproductlist/cartproductlist.component';
import { ContactComponent } from './contact/contact.component';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { RegisterComponent } from './register/resgister.component';

const routes: Routes = [
  
    {path:'home' , component: HomeComponent},
    {path:'contact' , component:ContactComponent},
    {path:'cart' ,component:CartComponent},
   
    {path:'register' , component:RegisterComponent},
    {path: 'login', component:LoginComponent},
    {path:'productlist/:productid', component: CartproductlistComponent},
    {path:'productlist' , component:ProductlistComponent}
    
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes), ReactiveFormsModule, FormsModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
