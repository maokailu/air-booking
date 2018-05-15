package com.cumt.pojo;

/**
 * Created by Administrator on 2018-05-15.
 */
public class OrderItem {
    private String orderItemId;
    private String orderId;
    private String ticketId;
    private String passengerId;
    private String seatRequire;

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public String getSeatRequire() {
        return seatRequire;
    }

    public void setSeatRequire(String seatRequire) {
        this.seatRequire = seatRequire;
    }

}
