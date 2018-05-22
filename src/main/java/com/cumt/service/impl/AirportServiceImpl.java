package com.cumt.service.impl;

import com.cumt.mapper.AirportMapper;
import com.cumt.mapper.CityMapper;
import com.cumt.pojo.Airport;
import com.cumt.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018-05-22.
 */
@Service
public class AirportServiceImpl  implements AirportService {
    @Autowired
    public AirportMapper airportMapper;
}
