// login-screen.component.ts
import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { AuthInterceptor } from 'src/app/AuthInterceptor';
import { AuthService2 } from 'src/app/AuthService2';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  hide= true;
  isPhone$!: Observable<boolean>;

  //Variabili login
  username = new FormControl ('', [ Validators.required]);
  password = new FormControl ('', [ Validators.required]);

  constructor(private authS: AuthService2, private router: Router) {}

ngOnInit(): void {
  
  if(this.authS.isAuthenticated()) {
    this.router.navigate(['profile'])
  }else{
    this.router.navigate(['login'])
  }
}

login():void{
  if(this.username.value !== null && this.password.value !== null){
    if(this.username.value.length>0 && this.password.value.length>0){
      this.authS.login(this.username.value, this.password.value);
    }
  }
}
}
