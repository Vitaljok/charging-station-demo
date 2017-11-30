import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import 'rxjs/add/operator/switchMap';
import { DataService } from '../data.service';
import { ChargingStation } from '../domain';

@Component({
  selector: 'app-station-details',
  templateUrl: './station-details.component.html',
  styleUrls: ['./station-details.component.css']
})
export class StationDetailsComponent implements OnInit {
  station: ChargingStation = new ChargingStation();
  cities: string[] = ['Rīga', 'Jelgava', 'Ventspils', 'Daugavpils', 'Liepāja', 'Rēzekne'];

  constructor(
    private route: ActivatedRoute,
    private service: DataService,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.params
      .switchMap((params) => this.service.getStationDetails(params['id']))
      .subscribe((data) => this.station = data, (err) => this.router.navigate(['']));
  }

  saveClicked(): void {
    console.log('Saving', this.station);
  }

  cancelClicked(): void {
    console.log('Canceling');
    this.router.navigate(['']);
  }
}
