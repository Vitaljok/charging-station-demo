import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/observable/of';
import 'rxjs/add/operator/delay';
import 'rxjs/add/operator/map';

import { ChargingStation } from './domain';

@Injectable()
export class DataService {
  private stations: ChargingStation[] = [
    new ChargingStation(1, 'Jelgava', 'Liela iela 2'),
    new ChargingStation(2, 'Jelgava', 'Akademijas iela 23', false),
    new ChargingStation(3, 'Jelgava', 'Čakstes bulvāris 5'),
    new ChargingStation(4, 'Rīga', 'Brīvības iela 123'),
    new ChargingStation(5, 'Rīga', 'Balasta dambis 1a', false),
  ];

  constructor(private http: Http) { }

  getStations(): Observable<ChargingStation[]> {
    return this.http.get('https://data.science.itf.llu.lv/api/stations')
      .map(response => response.json() as ChargingStation[]);
  }

  getStationsFake(): Observable<ChargingStation[]> {
    // WARNING!
    // Fake processing delay used for demonstration purposes.
    return Observable.of(this.stations).delay(500);
  }
}
