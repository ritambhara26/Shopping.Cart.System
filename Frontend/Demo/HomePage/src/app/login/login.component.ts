import { Component, OnInit } from '@angular/core';
import { FormControl, FormBuilder, FormGroup, Validators} from '@angular/forms';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { response } from 'express';
import { JwtClientService } from '../jwt-client-service';

import { Observable } from 'rxjs';
import { Token } from '@angular/compiler';
import { map, tap } from 'rxjs/operators';

//import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


 //*registering user deatils
//user: User=new User({ id: "", username: "", email: "", password: "" });

//user: User=new User("","","","")
//*login 
authenticationRequest:any={

  "username":"",
  "password":"",
};
surveyForm!: FormGroup;
submitted= false;
response:any;

//*this is for declaring toggle password

public showPassword: boolean = false;

constructor(private service:JwtClientService,private  formBuilder: FormBuilder,private router:Router) { }

onSubmit():void

{

 //console.log("form is submitted");
 if((this.authenticationRequest.username=='admin'&& this.authenticationRequest.password=='admin123')){
 
  window.location.href="/productlist" 

 }else{

  alert("Log-in Successful");

 }

 if((this.authenticationRequest.username!=''&& this.authenticationRequest.password!='')&&(this.authenticationRequest.username!=null && this.authenticationRequest.password!=null))

 {
   console.log("we have to submit the form");
   this.service.authenticateClient(this.authenticationRequest)
   .subscribe((data:any)=>

    {
      console.log(data);
// localStorage.setItem('token',data)

    this.service.loginUser(data)
     if(this.service.isLoggedIn()==true)

     {
    window.location.href="/productlist"
     } 

     else

     {
       alert("Log-in Successful");

     } 

    },

    (error:any)=>

     {
       console.log(error);

     }
     );
    }
 
 else

 {
   alert("Fileds are empty!!");

 }

}

ngOnInit(): void {

}

//*togglepassword method declaration  
public togglePasswordVisibility(): void {
 this.showPassword = !this.showPassword; 
}
}
