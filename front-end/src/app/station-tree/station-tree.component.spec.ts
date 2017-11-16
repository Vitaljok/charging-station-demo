import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StationTreeComponent } from './station-tree.component';

describe('StationTreeComponent', () => {
  let component: StationTreeComponent;
  let fixture: ComponentFixture<StationTreeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StationTreeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StationTreeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
