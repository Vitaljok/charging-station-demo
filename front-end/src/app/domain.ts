export class ChargingStation {
  // plain simple public class fields
  power: number;
  price: number;
  // class fields defined via constructor parameters
  constructor(public id: number,
    public city: string,
    public address: string,
    public isActive: boolean = true) { }
}
