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
  stations:ChargingStation[] = [
    new ChargingStation(1, 'Jelgava', 'Liela iela 2'),
    new ChargingStation(2, 'Jelgava', 'Akademijas iela 23', false),
    new ChargingStation(3, 'Jelgava', 'Čakstes bulvāris 5'),
    new ChargingStation(4, 'Rīga', 'Brīvības iela 123'),
    new ChargingStation(5, 'Rīga', 'Balasta dambis 1a', false),
  ];
}
