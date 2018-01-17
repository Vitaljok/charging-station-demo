package lv.llu.itf.demo.charging.stations;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StationBean {
    private long id;
    private String name;
    private Double power;
}
