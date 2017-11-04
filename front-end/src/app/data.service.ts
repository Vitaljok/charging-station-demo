import { Injectable } from '@angular/core';
import { ChargingStation } from "./domain";

@Injectable()
export class DataService {
  private stations: ChargingStation[] = [
    new ChargingStation(1, 'Jelgava', 'Liela iela 2'),
    new ChargingStation(2, 'Jelgava', 'Akademijas iela 23', false),
    new ChargingStation(3, 'Jelgava', 'Čakstes bulvāris 5'),
    new ChargingStation(4, 'Rīga', 'Brīvības iela 123'),
    new ChargingStation(5, 'Rīga', 'Balasta dambis 1a', false),
  ];

  constructor() { }

  getStations():ChargingStation[] {
    // WARNING!
    // Fake processing delay used for demonstration purposes.
    let start = Date.now();
    while (Date.now() < start + 2000) {}

    return this.stations;
  }
}
