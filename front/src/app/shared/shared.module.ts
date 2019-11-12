import { BypassSecurityPipe } from './pipe/bypass-security.pipe';
import { RouterModule } from '@angular/router';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';
import { NgModule } from '@angular/core';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [HeaderComponent, BypassSecurityPipe],
  imports: [MatToolbarModule, MatButtonModule, RouterModule],
  exports: [HeaderComponent, BypassSecurityPipe]
})
export class SharedModule {}
