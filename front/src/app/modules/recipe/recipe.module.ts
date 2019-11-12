import { ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { RecipesRoutingModule } from './recipe-routing.module';
import { RecipesListComponent } from './pages/recipes-list/recipes-list.component';
import { EditRecipesComponent } from './pages/edit-recipes/edit-recipes.component';
import { DisplayRecipeComponent } from './pages/display-recipe/display-recipe.component';
import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    DisplayRecipeComponent,
    EditRecipesComponent,
    RecipesListComponent
  ],
  imports: [
    SharedModule,
    CommonModule,
    RecipesRoutingModule,
    MatButtonModule,
    MatInputModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: []
})
export class RecipeModule {}
