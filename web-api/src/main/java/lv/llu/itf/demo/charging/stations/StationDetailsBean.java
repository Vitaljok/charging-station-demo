package lv.llu.itf.demo.charging.stations;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class StationDetailsBean extends StationBean {
    private String createdBy;
    private ZonedDateTime createdTs;
}
