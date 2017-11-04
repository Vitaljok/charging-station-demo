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
    // observable starts processing when subscribe() method is called
    this.service.getStations().subscribe(
      (data: ChargingStation[]) => {
        // code inside lambda will be executed asynchronously when data arrives
        // any complex logic might be implemented here
        this.stations = data;
      }
    );
  }
}
