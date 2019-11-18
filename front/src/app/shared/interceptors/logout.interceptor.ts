import { AuthenticationService } from '../../core/authentication/authentication.service';
import { HttpService } from '../../core/http/http.service';
import { catchError } from 'rxjs/operators';
import { Observable, throwError } from 'rxjs';
import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpErrorResponse
} from '@angular/common/http';

@Injectable()
export class LogoutInterceptor implements HttpInterceptor {
  constructor(private authenticationService: AuthenticationService) {}

  isLoggingOut = false;

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      catchError((err: HttpErrorResponse) => {
        switch (err.status) {
          case 401:
            console.log('Disconnected');
            if (!this.isLoggingOut) {
              this.isLoggingOut = true;
              this.authenticationService.logout();
            } else {
              this.isLoggingOut = false;
            }
            break;
        }
        return throwError(err);
      })
    );
  }
}
