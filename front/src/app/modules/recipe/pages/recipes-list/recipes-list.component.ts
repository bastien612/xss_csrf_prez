import { RecipeService } from './../../../../shared/services/recipe-service/recipe.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-recipes-list',
  templateUrl: './recipes-list.component.html',
  styleUrls: ['./recipes-list.component.scss']
})
export class RecipesListComponent implements OnInit {
  recipes = [];

  constructor(private recipeService: RecipeService) {}

  ngOnInit() {
    this.updateList();
  }

  updateList(): void {
    this.recipeService
      .updateList()
      .subscribe(response => (this.recipes = response));
  }

  clearRecipes(): void {
    this.recipeService.clearRecipes().subscribe(() => this.updateList());
  }
}
