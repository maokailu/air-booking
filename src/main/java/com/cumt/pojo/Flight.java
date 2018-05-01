package com.cumt.pojo;

public class Flight {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private String departCityCode;
    public String getDepartCityCode() {
        return departCityCode;
    }
    public void setDepartCityCode(String departCityCode) {
        this.departCityCode = departCityCode;
    }
    private String arriveCityCode;
    public String getArriveCityCode() {
        return arriveCityCode;
    }
    public void setArriveCityCode(String arriveCityCode) {
        this.arriveCityCode = arriveCityCode;
    }

    @Override
    public String toString() {
        return "Category [departCityCode=" + departCityCode + ", arriveCityCode=" + arriveCityCode + "]";
    }
}
