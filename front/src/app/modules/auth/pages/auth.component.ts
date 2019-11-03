import { AuthenticationService } from './../../../core/authentication/authentication.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {
  authForm: FormGroup;

  constructor(private authService: AuthenticationService) {}

  ngOnInit(): void {
    this.authForm = new FormGroup({
      login: new FormControl(),
      password: new FormControl()
    });
  }

  connect(authData) {
    this.authService.connect(authData.login, authData.password);
  }
}
