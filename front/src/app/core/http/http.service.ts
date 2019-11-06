import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import {
  HttpClientModule,
  HttpResponse,
  HttpParams
} from '@angular/common/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private backendUrl = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  getToken(login: string, password: string): Observable<any> {
    const params = new HttpParams()
      .set('username', login)
      .set('password', password);

    const headers = new HttpHeaders().set(
      'Content-Type',
      'application/x-www-form-urlencoded'
    );

    return this.httpClient.post(
      this.backendUrl + 'login?username=' + login + '&password=' + password,
      ''
    );
  }
}
