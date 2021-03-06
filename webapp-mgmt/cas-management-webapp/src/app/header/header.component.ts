import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Messages} from '../messages';
import {Router} from '@angular/router';
import {Location} from '@angular/common';
import {UserService} from '../user.service';
import {ControlsService} from '../controls/controls.service';
import {AppConfigService} from '../app-config.service';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @ViewChild('search') search: ElementRef;

  type: String;

  constructor(public messages: Messages,
              public router: Router,
              public location: Location,
              public appService: AppConfigService,
              public userService: UserService,
              public controlsService: ControlsService,
              public snackBar: MatSnackBar) { }

  ngOnInit() {
  }

  doSearch(val: string) {
    this.router.navigate( ['search', val]);
  }

  logout() {
    window.location.href = 'logout.html';
  }

  isAdmin(): boolean {
    return this.userService.user && this.userService.user.administrator;
  }

  isSyncScript(): boolean {
    return this.appService.config.syncScript;
  }

  sync() {
    this.controlsService.sync().
      subscribe(
        () => {
          this.snackBar
            .open('Services Synchronized',
              'Dismiss',
              {duration: 5000}
            );
      });
  }

}
