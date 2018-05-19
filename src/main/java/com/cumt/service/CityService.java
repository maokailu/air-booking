package com.cumt.service;

import com.cumt.pojo.City;
import com.cumt.pojo.Flight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-05-02.
 */
public interface CityService {
    public List<City> getHotCitys();
    public City getCurrentCityByCityNum(String cityNum);
}