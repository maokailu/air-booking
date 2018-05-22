package com.cumt.service.impl;

import com.cumt.mapper.CityMapper;
import com.cumt.mapper.FlightMapper;
import com.cumt.pojo.Airport;
import com.cumt.pojo.City;
import com.cumt.pojo.Flight;
import com.cumt.service.CategoryService;
import com.cumt.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-05-02.
 */
@Service
public class CityServiceImpl implements CityService {
    @Autowired
    public CityMapper cityMapper;

    public List<City> getHotCitys(){
        return cityMapper.getHotCitys();
    };
    public City getCurrentCityByCityNum(String cityNum){
        return cityMapper.getCurrentCityByCityNum(cityNum);
    };

    public List<City> getAirportsGroupByCity(String text){
        return cityMapper.getAirportsGroupByCity(text);
    };
}
