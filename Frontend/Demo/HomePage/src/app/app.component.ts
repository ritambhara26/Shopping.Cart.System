import { Component } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';

import { JwtClientService } from './jwt-client-service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'HomePage';
  public loggedIn=false;
  constructor(private service:JwtClientService) {
  }
  ngOnInit(): void {
    this.loggedIn=this.service.isLoggedIn()
    }

  logoutUser(){
    this.service.logout();

    location.reload()

    window.location.href="login"

  
  }
}

