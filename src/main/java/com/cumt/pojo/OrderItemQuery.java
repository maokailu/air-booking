package com.cumt.pojo;

/**
 * Created by Administrator on 2018-05-27.
 */
public class OrderItemQuery {
    private String orderItemId;

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public TicketQuery getTicket() {
        return ticket;
    }

    public void setTicket(TicketQuery ticket) {
        this.ticket = ticket;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getSeatRequire() {
        return seatRequire;
    }

    public void setSeatRequire(String seatRequire) {
        this.seatRequire = seatRequire;
    }

    private Order order;
    private TicketQuery ticket;
    private Passenger passenger;
    private String seatRequire;
}
