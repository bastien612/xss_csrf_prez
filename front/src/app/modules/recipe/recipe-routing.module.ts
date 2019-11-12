import { DisplayRecipeComponent } from './pages/display-recipe/display-recipe.component';
import { EditRecipesComponent } from './pages/edit-recipes/edit-recipes.component';
import { RecipesListComponent } from './pages/recipes-list/recipes-list.component';
import { Routes, RouterModule, Router } from '@angular/router';
import { NgModule } from '@angular/core';

const routes: Routes = [
  {
    path: '',
    component: RecipesListComponent
  },
  {
    path: 'edit',
    component: EditRecipesComponent
  },
  {
    path: 'display',
    component: DisplayRecipeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RecipesRoutingModule {}
