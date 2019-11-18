import { Observable } from 'rxjs';
import { RecipeModel } from './../../shared/models/recipe.model';
import { environment } from './../../../environments/environment';
import { Injectable } from '@angular/core';
import {
  HttpClientModule,
  HttpResponse,
  HttpParams
} from '@angular/common/http';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private backendUrl = environment.apiUrl;

  constructor(private httpClient: HttpClient) {}

  createRecipe(title: string, body: string): Observable<RecipeModel> {
    return this.httpClient.post(this.backendUrl + 'recipe', {
      title,
      body
    });
  }

  fetchAllRecipe(): Observable<RecipeModel[]> {
    return this.httpClient.get<RecipeModel[]>(this.backendUrl + 'recipe/list');
  }

  clearRecipes(): Observable<any> {
    return this.httpClient.delete(this.backendUrl + 'recipe/list');
  }

  logout() {
    return this.httpClient.post(this.backendUrl + 'logout', '');
  }

  getToken(login: string, password: string): Observable<any> {
    // const params = new HttpParams()
    //   .set('username', login)
    //   .set('password', password);

    // const headers = new HttpHeaders().set(
    //   'Content-Type',
    //   'application/x-www-form-urlencoded'
    // );

    return this.httpClient.post(
      this.backendUrl + 'login?username=' + login + '&password=' + password,
      ''
    );
  }

  reconnect(): Observable<any> {
    return this.httpClient.get(this.backendUrl + 'customer');
  }
}
