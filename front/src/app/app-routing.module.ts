import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';

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
