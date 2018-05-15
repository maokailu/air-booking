package com.cumt.pojo;

/**
 * Created by Administrator on 2018-05-15.
 */
public class OrderInfo {
    private Order order;
    private OrderItem orderItem;
    private Ticket ticket;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
