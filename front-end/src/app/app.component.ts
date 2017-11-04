import { Component } from '@angular/core';

class ChargingStation {
  // plain simple public class fields
  power: number;
  price: number;
  // class fields defined via constructor parameters
  constructor(public id: number,
    public city: string,
    public address: string,
    public isActive: boolean = true) { }
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // instance initialization via constructor
  firstStation: ChargingStation = new ChargingStation(1, 'Jelgava', 'Liela iela 2');

  // instance initialization via JSON notation
  secondStation: ChargingStation = {
    id: 2,
    address: 'Akademijas iela 23',
    city: 'Jelgava',
    power: 20,
    isActive: false,
    price: 0.57
  };
}
