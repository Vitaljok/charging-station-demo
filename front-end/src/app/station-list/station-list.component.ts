import { Component, OnInit } from '@angular/core';
import { ChargingStation } from "../domain";
import { DataService } from "../data.service";

@Component({
  selector: 'app-station-list',
  templateUrl: './station-list.component.html',
  styleUrls: ['./station-list.component.css']
})
export class StationListComponent  implements OnInit {
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
