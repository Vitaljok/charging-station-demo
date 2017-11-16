import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';
import { HttpModule } from "@angular/http";

import { AppComponent } from './app.component';
import { DataService } from "./data.service";
import { StationListComponent } from './station-list/station-list.component';
import { StationTreeComponent } from './station-tree/station-tree.component';


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
    path: '**',
    redirectTo: 'list'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    StationListComponent,
    StationTreeComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [DataService],
  bootstrap: [AppComponent]
})
export class AppModule { }
