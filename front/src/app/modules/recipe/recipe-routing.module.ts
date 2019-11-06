import { DisplayrecipeComponent } from './pages/display-recipe/display-recipe.component';
import { EditrecipesComponent } from './pages/edit-recipes/edit-recipes.component';
import { recipesListComponent } from './pages/recipes-list/recipes-list.component';
import { Routes, RouterModule, Router } from '@angular/router';
import { NgModule } from '@angular/core';

const routes: Routes = [
  {
    path: '',
    component: recipesListComponent
  },
  {
    path: 'edit/',
    component: EditrecipesComponent
  },
  {
    path: 'display/',
    component: DisplayrecipeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class recipesRoutingModule {}
