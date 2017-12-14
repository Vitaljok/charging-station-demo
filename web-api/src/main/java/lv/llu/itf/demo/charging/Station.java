package lv.llu.itf.demo.charging;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Station {
    private Long id;
    private String name;
    private Double power;
    private LocalDateTime createdTs;
    private LocalDateTime updatedTs;
    private long version;
}
