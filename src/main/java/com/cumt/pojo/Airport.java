package com.cumt.pojo;

/**
 * Created by Administrator on 2018-05-22.
 */
//实为城市信息表
public class Airport {
    private int id;
    private String airportCode;
    private String airportName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
}
