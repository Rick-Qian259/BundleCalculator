package com.jr.bundlecalculator.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class OrderItems {
    private String brandName;
    private int[] bundle;
    private Map<Integer, Double> bundleAndPriceMap;
    private String amount;

    private String minimalNumber;
    private String minimalCase;

    private String totalSpend;

    private String totalAmount;

    private List<String> bundleList;

    private List<String> priceList;

    public OrderItems() {
        bundleAndPriceMap = new HashMap<>();
        bundleList = new ArrayList<>();
        priceList = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "\n" + totalAmount + " " + brandName + " $" + totalSpend;
        for (int i = 0; i < bundleList.size(); i++) {
            result += "\n" + bundleList.get(i) + " $" + priceList.get(i);
        }
        return result;
    }
}
