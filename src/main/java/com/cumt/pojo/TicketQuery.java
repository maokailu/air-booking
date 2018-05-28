package com.cumt.pojo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018-05-27.
 */
public class TicketQuery {
    private String ticketId;
    private Flight flight;

    public CabinClass getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(CabinClass cabinClass) {
        this.cabinClass = cabinClass;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    private BigDecimal discount;
    private CabinClass cabinClass;
    private BigDecimal fuelCharge;
    private BigDecimal airportTax;
    private BigDecimal TicketPrice;
}
