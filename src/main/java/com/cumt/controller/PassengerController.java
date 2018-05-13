package com.cumt.controller;

import com.cumt.service.FlightService;
import com.cumt.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018-05-13.
 */

@Controller
@RequestMapping("")
public class PassengerController {
    @Autowired
    PassengerService passengerService;
}
