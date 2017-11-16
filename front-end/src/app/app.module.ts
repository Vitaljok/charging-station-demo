import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { DataService } from "./data.service";
import { StationListComponent } from './station-list/station-list.component';
import { StationTreeComponent } from './station-tree/station-tree.component';

@NgModule({
  declarations: [
    AppComponent,
    StationListComponent,
    StationTreeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
