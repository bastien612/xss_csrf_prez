import { ErrorRoutingModule } from './error-routing.module';
import { ErrorComponent } from './pages/error.component';
import { NgModule } from '@angular/core';

@NgModule({
  declarations: [ErrorComponent],
  imports: [ErrorRoutingModule],
  providers: [],
  bootstrap: []
})
export class ErrorModule {}
