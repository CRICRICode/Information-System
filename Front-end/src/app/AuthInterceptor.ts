import { Injectable } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import { Observable, switchMap } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthService2 } from './AuthService2';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  jwtDecoder= new JwtHelperService();
  constructor( private auth2 : AuthService2){}
  private richiestaBeforeUpdate! : HttpRequest<any>;


  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.auth2.isAuthenticated()) {
      this.richiestaBeforeUpdate = request;
      if (this.isFinished()) {
        return this.auth2.updateToken().pipe(
          switchMap(() => {
            const authorizedRequest = request.clone({
              setHeaders: {
                'Authorization': `Bearer ${window.localStorage.getItem('TOKEN')}`,
              }
            });
            console.log(authorizedRequest);
            return next.handle(authorizedRequest);
          })
        );
      }
      return next.handle(this.handleAuthorizedRequest(this.richiestaBeforeUpdate, next));
    }
    else
    {
      const authorizedRequest = request.clone();
      return next.handle(authorizedRequest);
    }
  }
  private handleAuthorizedRequest(request: HttpRequest<any>, next: HttpHandler) {
    const authorizedRequest = request.clone({
      setHeaders: {
        'Authorization': `Bearer ${window.localStorage.getItem('TOKEN')}`,
      }
    });
    console.log(authorizedRequest);
    return authorizedRequest;
  }

  private isFinished(): boolean {
    const parsedToken = window.localStorage.getItem('TOKEN');
    if (parsedToken != null) {
      const decodedToken = this.jwtDecoder.decodeToken(parsedToken);
      const currentTime = Math.floor(Date.now() / 1000);
      console.log("TOKEN" +decodedToken.exp)
      console.log("Tempo corrente"+currentTime)
      console.log("Tempo corrente incrementato"+(currentTime+10))
      return decodedToken.exp < (currentTime+10);
    }
    return false;
  }
}