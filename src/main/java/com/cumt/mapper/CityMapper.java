package com.cumt.mapper;

import com.cumt.pojo.City;

import java.util.List;

/**
 * Created by Administrator on 2018-05-02.
 */
public interface CityMapper {
    List<City> queryByCountry(int countryId);
}
