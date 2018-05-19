package com.cumt.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.DateTimeException;

public class Flight implements Serializable {
    private long id;
    private String flightId;
    private String planeId;
    private String departAirportCode;
    private String arriveAirportCode;
    private Timestamp departTime;
    private Timestamp returnTime;
    private int flightType;
    private BigDecimal baseFire;
    private int firstClassCount;
    private int businessClassCount;
    private int economyClassCount;
    private BigDecimal voyage;
    private String departAirportName;
    private String arriveAirportName;
    private BigDecimal ticketPrice;
    private BigDecimal airportTax;


    public BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public BigDecimal getAirportTax() {
        return airportTax;
    }

    public void setAirportTax(BigDecimal airportTax) {
        this.airportTax = airportTax;
    }

    public String getDepartAirportName() {
        return departAirportName;
    }

    public void setDepartAirportName(String departAirportName) {
        this.departAirportName = departAirportName;
    }

    public String getArriveAirportName() {
        return arriveAirportName;
    }

    public void setArriveAirportName(String arriveAirportName) {
        this.arriveAirportName = arriveAirportName;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPlaneId() {
        return planeId;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public String getDepartAirportCode() {
        return departAirportCode;
    }

    public void setDepartAirportCode(String departAirportCode) {
        this.departAirportCode = departAirportCode;
    }

    public String getArriveAirportCode() {
        return arriveAirportCode;
    }

    public void setArriveAirportCode(String arriveAirportCode) {
        this.arriveAirportCode = arriveAirportCode;
    }

    public Timestamp getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Timestamp departTime) {
        this.departTime = departTime;
    }

    public Timestamp getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Timestamp returnTime) {
        this.returnTime = returnTime;
    }

    public int getFlightType() {
        return flightType;
    }

    public void setFlightType(int flightType) {
        this.flightType = flightType;
    }

    public BigDecimal getBaseFire() {
        return baseFire;
    }

    public void setBaseFire(BigDecimal baseFire) {
        this.baseFire = baseFire;
    }

    public int getFirstClassCount() {
        return firstClassCount;
    }

    public void setFirstClassCount(int firstClassCount) {
        this.firstClassCount = firstClassCount;
    }

    public int getBusinessClassCount() {
        return businessClassCount;
    }

    public void setBusinessClassCount(int businessClassCount) {
        this.businessClassCount = businessClassCount;
    }

    public int getEconomyClassCount() {
        return economyClassCount;
    }

    public void setEconomyClassCount(int economyClassCount) {
        this.economyClassCount = economyClassCount;
    }

    public BigDecimal getVoyage() {
        return voyage;
    }

    public void setVoyage(BigDecimal voyage) {
        this.voyage = voyage;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
