import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-station-list-item',
  templateUrl: './station-list-item.component.html',
  styleUrls: ['./station-list-item.component.css']
})
export class StationListItemComponent {
  @Input()
  text: string;
  @Input()
  isActive: boolean;
  @Input()
  isChild: boolean;
}
