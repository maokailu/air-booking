package com.cumt.pojo;

/**
 * Created by Administrator on 2018-05-12.
 */
public class FlightSearch extends Flight {
    private String departCityCode;
    private String arriveCityCode;
    private String departAirportCode;
    private String arriveAirportCode;

    @Override
    public String getDepartAirportCode() {
        return departAirportCode;
    }

    @Override
    public void setDepartAirportCode(String departAirportCode) {
        this.departAirportCode = departAirportCode;
    }

    @Override
    public String getArriveAirportCode() {
        return arriveAirportCode;
    }

    @Override
    public void setArriveAirportCode(String arriveAirportCode) {
        this.arriveAirportCode = arriveAirportCode;
    }

    private int classType;

    public String getDepartCityCode() {
        return departCityCode;
    }

    public void setDepartCityCode(String departCityCode) {
        this.departCityCode = departCityCode;
    }

    public String getArriveCityCode() {
        return arriveCityCode;
    }

    public void setArriveCityCode(String arriveCityCode) {
        this.arriveCityCode = arriveCityCode;
    }

    public int getClassType() {
        return classType;
    }

    public void setClassType(int classType) {
        this.classType = classType;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    private int passenger;
}
