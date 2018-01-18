package lv.llu.itf.demo.charging.stations;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class StationDetailsBean extends StationBean {
    private String createdBy;
    private ZonedDateTime createdTs;
    private List<String> eventMessages;
}

