import { catchError, tap } from "rxjs/operators";
import { RecipeModel } from "./../../models/recipe.model";
import { Observable, of } from "rxjs";
import { Injectable } from "@angular/core";
import { HttpService } from "app/core/http/http.service";

@Injectable({
  providedIn: "root"
})
export class RecipeService {
  allRecipe: RecipeModel[];

  constructor(private httpService: HttpService) {
    this.allRecipe = [];
  }

  createRecipe(title: string, body: string): Observable<RecipeModel> {
    return this.httpService.createRecipe(title, body);
  }

  updateList(): Observable<any> {
    return this.httpService.fetchAllRecipe().pipe(
      tap(response => {
        this.allRecipe = response;
        return of(this.allRecipe);
      }),
      catchError(error => {
        console.log("Error when fetching recipes");
        alert(`Erreur lors de la récupération des recettes: ${error}`);
        return of([]);
      })
    );
  }

  getAllRecipe(): RecipeModel[] {
    return this.allRecipe;
  }

  clearRecipes(): Observable<void> {
    return this.httpService.clearRecipes();
  }
}
