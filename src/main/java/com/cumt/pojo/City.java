package com.cumt.pojo;

import java.math.BigInteger;

/**
 * Created by Administrator on 2018-04-30.
 */
public class City {
    private long id;
    private String cityCode;
    private String cityName;
    private String countryCode;
    private String cityNum;

    public String getCityNum() {
        return cityNum;
    }

    public void setCityNum(String cityNum) {
        this.cityNum = cityNum;
    }

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public long getId() {
        return id;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getCityCode() {
        return cityCode;
    }
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
