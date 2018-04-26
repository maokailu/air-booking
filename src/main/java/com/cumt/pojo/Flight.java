package com.cumt.pojo;

public class Flight {
    private Integer flight_id;
    private String name;

    public Integer getFlightId() {
        return flight_id;
    }
    public void setFlightId(Integer flightId) {
        this.flight_id = flightId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Flight [flightId=" + flight_id + ", name=" + name + "]";
    }
}
