import { AuthenticationService } from './authentication.service';
import { Injectable } from '@angular/core';
import { Router, CanActivate } from '@angular/router';

@Injectable()
export class AuthenticationGuardService implements CanActivate {
  constructor(
    public authenticationService: AuthenticationService,
    public router: Router
  ) {}

  canActivate(): boolean {
    if (!this.authenticationService.isConnected()) {
      this.router.navigateByUrl('/auth');
      return false;
    }
    return true;
  }
}
