import { Injectable } from '@angular/core';
import { HttpService } from '../http/http.service';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private httpService: HttpService) {}

  login(login, password) {
    console.log('connect : ', login);
    console.log('pass : ', password);
    return this.httpService.getToken(login, password);
  }
}
