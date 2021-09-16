package com.jr.bundlecalculator.entity;


import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class Order {
    private List<OrderItems> orderItemsList;

    public Order() {
        orderItemsList = new ArrayList<>();
    }


    public void addOrderItems(@NonNull OrderItems orderItems) {
        orderItemsList.add(orderItems);
    }

    @Override
    public String toString() {
        return orderItemsList.toString();
    }
}
