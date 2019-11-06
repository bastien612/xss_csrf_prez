import { recipesListComponent } from './pages/recipes-list/recipes-list.component';
import { EditrecipesComponent } from './pages/edit-recipes/edit-recipes.component';
import { DisplayrecipeComponent } from './pages/display-recipe/display-recipe.component';
import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    DisplayrecipeComponent,
    EditrecipesComponent,
    recipesListComponent
  ],
  imports: [SharedModule, CommonModule],
  providers: [],
  bootstrap: []
})
export class RecipeModule {}
