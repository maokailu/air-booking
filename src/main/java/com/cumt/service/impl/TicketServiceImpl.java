package com.cumt.service.impl;

import com.cumt.mapper.PassengerMapper;
import com.cumt.mapper.TicketMapper;
import com.cumt.pojo.Ticket;
import com.cumt.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018-05-15.
 */

@Service
public class TicketServiceImpl implements TicketService{
    @Autowired
    TicketMapper ticketMapper;
    public int getTicketId(Ticket ticket){
        return ticketMapper.getTicketId(ticket);
    };
}
