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

  constructor(private httpService: HttpService, private router: Router) {}

  isConnected() {
    console.log('is user connected :', this.isUserConnected);
    return this.isUserConnected;
  }

  login(login, password) {
    console.log('connect : ', login);
    console.log('pass : ', password);
    return this.httpService.getToken(login, password).pipe(
      tap(response => {
        console.log('success');
        this.isUserConnected = true;
        this.currentUser = new User(login);
        return of(true);
      }),
      catchError(error => {
        console.log('failure');
        this.isUserConnected = false;
        throw error;
      })
    );
  }

  logout() {
    return this.httpService.logout().subscribe(() => {
      this.isUserConnected = false;
      this.currentUser = undefined;
      console.log('pouet');
      this.router.navigateByUrl('/home');
    });
  }

  getUsername(): string {
    return this.currentUser.name;
  }
}
