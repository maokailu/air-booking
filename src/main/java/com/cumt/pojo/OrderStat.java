package com.cumt.pojo;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2018-05-28.
 */
public class OrderStat {
    private Timestamp orderDate;
    private Integer orderNum;

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}
