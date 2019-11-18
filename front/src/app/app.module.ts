import { RecipeModule } from './modules/recipe/recipe.module';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { HomeModule } from './modules/home/home.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { AuthenticationGuardService } from './core/authentication/authentication-guard.service';
import { LogoutInterceptor } from './shared/interceptors/logout.interceptor';

@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HomeModule,
    HttpClientModule,
    AppRoutingModule,
    CommonModule,
    RecipeModule
  ],
  providers: [
    AuthenticationGuardService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: LogoutInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
