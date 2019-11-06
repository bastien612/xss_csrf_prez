import { environment } from './../../../../environments/environment';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { AuthenticationService } from 'app/core/authentication/authentication.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {
  authForm: FormGroup;

  constructor(
    private authService: AuthenticationService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.authForm = new FormGroup({
      login: new FormControl(),
      password: new FormControl()
    });
  }

  connect(authData) {
    this.authService.login(authData.login, authData.password).subscribe(
      () => {
        console.log('redirect home');
        this.router.navigateByUrl('/home');
      },
      () => {
        console.log('redirect error');
        this.router.navigateByUrl('/error');
      }
    );
  }
}
