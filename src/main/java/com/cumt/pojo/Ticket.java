package com.cumt.pojo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018-05-15.
 */
public class Ticket {
    private String ticketId;
    private String flightId;
    private BigDecimal discount;
    private int cabinClassId;
    private BigDecimal fuelCharge;
    private BigDecimal airportTax;
    private BigDecimal TicketPrice;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getCabinClassId() {
        return cabinClassId;
    }

    public void setCabinClassId(int cabinClassId) {
        this.cabinClassId = cabinClassId;
    }

    public BigDecimal getFuelCharge() {
        return fuelCharge;
    }

    public void setFuelCharge(BigDecimal fuelCharge) {
        this.fuelCharge = fuelCharge;
    }

    public BigDecimal getAirportTax() {
        return airportTax;
    }

    public void setAirportTax(BigDecimal airportTax) {
        this.airportTax = airportTax;
    }

    public BigDecimal getTicketPrice() {
        return TicketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        TicketPrice = ticketPrice;
    }
}
