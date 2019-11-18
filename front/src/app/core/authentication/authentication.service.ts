import { User } from './../../shared/models/user.model';
import { Injectable } from '@angular/core';
import { HttpService } from '../http/http.service';
import { Router } from '@angular/router';
import { of, Observable } from 'rxjs';
import { catchError, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  public isUserConnected = false;
  public currentUser: User;

  constructor(private httpService: HttpService, private router: Router) {
    if (!localStorage.getItem('isConnected')) {
      this.resetUserInfo();
    }
  }

  isConnected() {
    console.log('is user connected :', localStorage.getItem('isConnected'));
    if (localStorage.getItem('isConnected') === 'true') {
      return true;
    } else {
      return false;
    }
  }

  // reconnect() {
  //   console.log('try reconnect');
  //   if (!this.isUserConnected) {
  //     this.httpService.reconnect().subscribe(
  //       response => {
  //         if (response.name) {
  //           this.currentUser = new User(response.name);
  //           this.isUserConnected = true;
  //         }
  //       },
  //       () => {
  //         console.log('error when reconnect');
  //       }
  //     );
  //   }
  // }

  login(login, password) {
    console.log('connect : ', login);
    console.log('pass : ', password);
    return this.httpService.getToken(login, password).pipe(
      tap(response => {
        console.log('success');
        this.isUserConnected = true;
        this.currentUser = new User(login);
        localStorage.setItem('isConnected', 'true');
        localStorage.setItem('name', login);
        return of(true);
      }),
      catchError(error => {
        console.log('failure');
        this.isUserConnected = false;
        this.resetUserInfo();
        throw error;
      })
    );
  }

  logout() {
    return this.httpService.logout().subscribe(() => {
      this.resetUserInfo();
      this.router.navigateByUrl('/home');
    });
  }

  getUsername(): string {
    return localStorage.getItem('name');
  }

  resetUserInfo() {
    console.log('this.resetUserInfo');
    localStorage.setItem('isConnected', 'false');
    localStorage.setItem('name', 'inconnu');
    this.isUserConnected = false;
    this.currentUser = undefined;
  }
}
