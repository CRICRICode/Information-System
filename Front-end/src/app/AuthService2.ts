import { HttpClient, HttpErrorResponse, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap } from 'rxjs';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class AuthService2 {

  private REQUEST_LOGIN= "http://localhost:4200/auth/realms/SecurityPneuscervice/protocol/openid-connect/auth"
  private userURL = "https://localhost:8080/user";

  jwtDecoder = new JwtHelperService();

  constructor(private http : HttpClient, private router : Router) { }


  public isAuthenticated():boolean{
    const accessToken = window.localStorage.getItem('TOKEN');
    const refreshToken = window.localStorage.getItem('RTOKEN');
    const isLoggedIn = !(accessToken === null || refreshToken === null);
    return isLoggedIn;
  }

  public login(username : string, password: string){
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
    });

    const body = new HttpParams()
      .set("client_id", "client_rest_api")
      .set("grant_type", "password")
      .set("username", username)
      .set("password", password)
      .set("scope","openid");

      this.http.post<any>(this.REQUEST_LOGIN,body.toString(),{headers}).subscribe(
        (response:any)=>{
          // La richiesta POST ha avuto successo
          console.log('Risposta:', response);
          // Gestisci la risposta come desiderato
          var parsedResponse = JSON.stringify(response.access_token);
          let decodedToken = this.jwtDecoder.decodeToken(parsedResponse);
          console.log(decodedToken);
          window.localStorage.setItem('TOKEN',response.access_token);
          window.localStorage.setItem('RTOKEN',response.refresh_token);
          this.isAuthenticated();
          window.location.reload();
        },(error) => {
          alert("Errore nel login, Username o Password Errati!")
        })
      };


  public updateToken(){
    const headers = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded'
    });
    let body= new HttpParams()
    .set("client_id", "angular")
    .set("grant_type", "refresh_token");
    var token = window.localStorage.getItem('RTOKEN');
    if(token!=null){
      console.log(token);
      body = new HttpParams()
    .set("client_id", "angular")
    .set("grant_type", "refresh_token")
    .set('refresh_token',token);
    }
    window.localStorage.clear();
    console.log(body);
    return this.http.post<any>(this.REQUEST_LOGIN,body.toString(),{headers}).pipe(
      tap((response: any) => {
        if (response instanceof HttpErrorResponse) {
          console.log('Errore:', response.message);
        } else {
          console.log('Risposta:', response);
          window.localStorage.clear();
          // Gestisci la risposta come desiderato
          window.localStorage.setItem('TOKEN', response.access_token);
          window.localStorage.setItem('RTOKEN', response.refresh_token);
        }
      })
    );;
  }

  public register(user : User){
    this.http.post<any>(this.userURL+"/addUser",user).subscribe((response:any)=>
      {
        if(response instanceof HttpErrorResponse){
          alert(response.message);
        }
        this.login(user.username, user.password);
        this.isAuthenticated();
        this.router.navigateByUrl('/');
      });
  }

  public getUsername():string{
    var parsedResponse = JSON.stringify(window.localStorage.getItem('TOKEN'));
    let decodedToken = this.jwtDecoder.decodeToken(parsedResponse);
    return decodedToken.preferred_username;
  }

  public getRole(){
    var parsedResponse = JSON.stringify(window.localStorage.getItem('TOKEN'));
    let decodedToken = this.jwtDecoder.decodeToken(parsedResponse);
    let a : string[] = decodedToken.resource_access.angular.roles;
    return a.includes('admin');
  }
}
