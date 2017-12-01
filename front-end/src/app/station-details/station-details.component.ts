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
  isNew: boolean;

  constructor(
    private route: ActivatedRoute,
    private service: DataService,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.data.subscribe((data) => {
      this.isNew = data.isNew;
      if (!data.isNew) {
        this.route.params
          .switchMap((params) => {
            return this.service.getStationDetails(params['id']);
          })
          .subscribe((data) => this.station = data, (err) => this.router.navigate(['']));
      }
    });
  }

  saveClicked(): void {
    console.log('Saving', this.station);
    this.service.editStation(this.station)
      .subscribe((resp) => this.router.navigate(['']), (err) => console.log(err));
  }

  createClicked(): void {
    console.log('Creating', this.station);
    this.service.addStation(this.station)
      .subscribe((resp) => this.router.navigate(['']), (err) => console.log(err));
  }

  cancelClicked(): void {
    console.log('Canceling');
    this.router.navigate(['']);
  }

  deleteClicked(): void {
    this.service.deleteStation(this.station.id)
      .subscribe((resp) => this.router.navigate(['']), (err) => console.log(err));
  }
}
