import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { AuthenticationGuardService } from './core/authentication/authentication-guard.service';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: () =>
      import('./modules/home/home.module').then(mod => mod.HomeModule)
  },
  {
    path: 'auth',
    loadChildren: () =>
      import('./modules/auth/auth.module').then(mod => mod.AuthModule)
  },
  {
    path: 'recipe',
    loadChildren: () =>
      import('./modules/recipe/recipe.module').then(mod => mod.RecipeModule),
    canActivate: [AuthenticationGuardService]
  },
  {
    path: 'error',
    loadChildren: () =>
      import('./modules/error/error.module').then(mod => mod.ErrorModule)
  },
  { path: '**', redirectTo: '/error' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
