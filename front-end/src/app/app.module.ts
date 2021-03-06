import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HttpModule } from "@angular/http";
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { DataService } from "./data.service";
import { StationListComponent } from './station-list/station-list.component';
import { StationTreeComponent } from './station-tree/station-tree.component';
import { StationDetailsComponent } from './station-details/station-details.component';


const appRoutes: Routes = [
  {
    path: 'list',
    component: StationListComponent
  },
  {
    path: 'tree',
    component: StationTreeComponent
  },
  {
    path: 'stations/new',
    component: StationDetailsComponent,
    data: {
      isNew: true
    }
  },
  {
    path: 'stations/:id',
    component: StationDetailsComponent,
    data: {
      isNew: false
    }
  },
  {
    path: '**',
    redirectTo: 'list'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    StationListComponent,
    StationTreeComponent,
    StationDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
