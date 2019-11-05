import { environment } from './../../../../environments/environment';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AuthenticationService } from 'app/core/authentication/authentication.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {
  authForm: FormGroup;

  constructor(
    private authService: AuthenticationService,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.authForm = new FormGroup({
      login: new FormControl(),
      password: new FormControl()
    });
  }

  connect(authData) {
    this.authService.login(authData.login, authData.password);
  }

  onClick() {
    this.authService.login('admin', 'admin').subscribe(
      response => {
        console.log('Response : ', response);
      },
      error => {
        console.log('Error : ', error);
      }
    );
  }

  onClick2() {
    this.http.get(environment.apiUrl + 'hello').subscribe(
      response => {
        console.log('Response : ', response);
      },
      error => {
        console.log('Error : ', error);
      }
    );
  }
}
