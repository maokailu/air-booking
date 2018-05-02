package com.cumt.pojo;

/**
 * Created by Administrator on 2018-04-30.
 */
public class City {
    private int id;
    private String cityCode;
    private String cityName;
    private int countryId;

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCityCode() {
        return cityCode;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
