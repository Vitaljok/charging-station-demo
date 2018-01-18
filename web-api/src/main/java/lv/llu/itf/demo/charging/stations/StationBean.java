package lv.llu.itf.demo.charging.stations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StationBean {
    private long id;
    private String name;
    private Double power;
}
