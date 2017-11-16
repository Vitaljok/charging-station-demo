import { Component, OnInit } from '@angular/core';
import { ChargingStation } from "../domain";
import { DataService } from "../data.service";

@Component({
  selector: 'app-station-tree',
  templateUrl: './station-tree.component.html',
  styleUrls: ['./station-tree.component.css']
})
export class StationTreeComponent implements OnInit {
  cities: City[] = [];

  constructor(private service: DataService) { }

  ngOnInit(): void {
    this.service.getStations().subscribe(
      (data: ChargingStation[]) => {
        data.forEach((item) => {
          let city = this.getCityByName(item.city);
          city.stations.push(item);
        });
      }
    );
  }

  private getCityByName(name: string) {
    let city = this.cities.find((item: City) => item.name == name);
    if (!city) {
      city = new City(name);
      this.cities.push(city);
    }
    return city;
  }
}

class City {
  constructor(public name: string) { }
  stations: ChargingStation[] = [];
}
