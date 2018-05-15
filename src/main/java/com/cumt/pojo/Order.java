package com.cumt.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018-05-14.
 */
public class Order {
    private int id;
    private String orderId;
    private String userId;
    private String contactName;
    private Date orderDate;
    private int orderState;
    private BigDecimal totalTicketPrice;
    private BigDecimal totalFuelSurcharge;
    private BigDecimal totalAirportTax;
    private BigDecimal totalPrice;
    private String cellphone;
    private String email;
    private String zipCode;


    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public BigDecimal getTotalTicketPrice() {
        return totalTicketPrice;
    }

    public void setTotalTicketPrice(BigDecimal totalTicketPrice) {
        this.totalTicketPrice = totalTicketPrice;
    }

    public BigDecimal getTotalFuelSurcharge() {
        return totalFuelSurcharge;
    }

    public void setTotalFuelSurcharge(BigDecimal totalFuelSurcharge) {
        this.totalFuelSurcharge = totalFuelSurcharge;
    }

    public BigDecimal getTotalAirportTax() {
        return totalAirportTax;
    }

    public void setTotalAirportTax(BigDecimal totalAirportTax) {
        this.totalAirportTax = totalAirportTax;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }


    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
