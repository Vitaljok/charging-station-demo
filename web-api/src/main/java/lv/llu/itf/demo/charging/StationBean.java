package lv.llu.itf.demo.charging;

public class StationBean {
    private long id;
    private String name;
    private Double power;

    public StationBean(long id, String name, Double power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPower() {
        return power;
    }

    public void setPower(Double power) {
        this.power = power;
    }
}
