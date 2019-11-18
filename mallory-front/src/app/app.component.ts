import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'mallory-front';

  constructor(public httpClient: HttpClient) {}

  createRecipe(title: string, body: string): void {
    this.httpClient
      .post('http://localhost:4300/api/recipe', {
        title,
        body
      })
      .subscribe(
        () => {
          console.log('success');
        },
        error => {
          console.log('error : ', error);
        }
      );
  }
}
