import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  connect(login, password) {
    console.log('connect : ', login);
    console.log('pass : ', password);
  }
}
