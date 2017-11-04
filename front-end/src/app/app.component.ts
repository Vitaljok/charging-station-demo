import { Component, OnInit } from '@angular/core';
import { ChargingStation } from "./domain";
import { DataService } from "./data.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  stations: ChargingStation[] = [];

  constructor(private service: DataService) { }

  ngOnInit(): void {
    this.stations = this.service.getStations();
  }
}
