package lv.llu.itf.demo.charging;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StationDetailsBean extends StationBean {
    private Double power;
}

