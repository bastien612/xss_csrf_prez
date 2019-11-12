import { AuthenticationService } from 'app/core/authentication/authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  constructor(public authenticationService: AuthenticationService) {}

  ngOnInit() {}

  logout() {
    this.authenticationService.logout();
  }
}
