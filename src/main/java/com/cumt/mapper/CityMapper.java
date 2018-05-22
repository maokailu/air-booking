package com.cumt.mapper;

import com.cumt.pojo.Airport;
import com.cumt.pojo.City;
import com.cumt.pojo.Flight;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2018-05-02.
 */
public interface CityMapper {
    public List<City> getHotCitys();
    public City getCurrentCityByCityNum(@Param("cityNum")String cityNum);
    public List<City> getAirportsGroupByCity(@Param("text")String text);
}
