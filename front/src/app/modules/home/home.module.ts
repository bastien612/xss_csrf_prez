import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './pages/home.component';
import { NgModule } from '@angular/core';

@NgModule({
  declarations: [HomeComponent],
  imports: [HomeRoutingModule],
  providers: [],
  bootstrap: []
})
export class HomeModule {}
