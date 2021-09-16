package com.jr.bundlecalculator.processor;

import com.jr.bundlecalculator.brand.Brand;
import com.jr.bundlecalculator.entity.Order;
import com.jr.bundlecalculator.entity.OrderItems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class OrderProcessor {

    private static final String empty = " ";
    private static final String nextLine = "\n";
    private final Logger log = Logger.getLogger("InfoLogging");

    public Order convertInputDataToOrderObject(String inputData) {
        Order order = new Order();
        String[] singleLineOfData = inputData.split(nextLine);
        for (String lineOfData : singleLineOfData) {
            if (validInputData(lineOfData)) {
                order.addOrderItems(covertOneLineDataToOneItem(lineOfData));
            } else {
                log.warning("The input data " + lineOfData + " contains the invalid brand name or non-positive amount, please check the input");
            }
        }
        return order;
    }

    private OrderItems covertOneLineDataToOneItem(String OneLineData) {
        OrderItems orderItems = new OrderItems();
        String amount = OneLineData.split(empty)[0];
        String name = OneLineData.split(empty)[1];

        orderItems.setAmount(amount);
        orderItems.setBrandName(name);
        Brand brand = Brand.valueOf(name);
        orderItems.setBundle(brand.getPriceBundle());

        Map<Integer, Double> map = new HashMap<>();
        for (int i = 0; i < brand.getPriceBundle().length; i++) {
            map.put(brand.getPriceBundle()[i], brand.getPriceValue()[i]);
        }
        orderItems.setBundleAndPriceMap(map);
        return orderItems;
    }

    private boolean validInputData(String lineOfData) {
        int amount = 0;
        try {
            amount = Integer.parseInt(lineOfData.split(empty)[0]);
        } catch (Exception e) {
            log.warning("Input amount cannot be non-number");
        }
        return (amount > 0) && (Arrays.stream(Brand.values()).anyMatch((input) -> input.name().equals(lineOfData.split(empty)[1])));
    }
}
