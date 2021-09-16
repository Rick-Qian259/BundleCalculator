package com.jr.bundlecalculator.algorithm;

import com.jr.bundlecalculator.entity.Order;
import com.jr.bundlecalculator.entity.OrderItems;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Algorithm {
    private final static String slash = "/";
    private static final String empty = " ";
    private static final String times = " * ";

    public Order calculateNumberAndCase(@NonNull Order order) {
        for (OrderItems item : order.getOrderItemsList()) {
            String amount = item.getAmount();
            int[] bundles = item.getBundle();
            String result;
            int moneyInt = Integer.parseInt(amount);

            do {
                result = calculateTheOptimiseNumbers(moneyInt, bundles);
                moneyInt++;
            } while (result.split(slash)[0].equals(String.valueOf(Integer.MAX_VALUE - 1)));
//      if the amount cannot be divided completely by bundles, such as 7 is Video' input, and its' bundles are 3,5,9.
//      Each time it should plus one for input amount, until the input can be divided completely by bundles.
            String minimalNumber = result.split(slash)[0];
            item.setMinimalNumber(minimalNumber);

            String minimalCase = result.split(slash)[1];
            item.setMinimalCase(minimalCase);
        }
        return order;
    }

    private String calculateTheOptimiseNumbers(int amount, int[] bundles) {
        String result;
        int[] dpArrays = new int[amount + 1];       // the dynamic programming algorithm array to store the case.
        int[] reverseArrays = new int[amount + 1];  // the reverse array is used for find the specific cases.
        dpArrays[0] = 0;
        for (int k = 1; k <= amount; k++) {
            dpArrays[k] = Integer.MAX_VALUE - 1;
            reverseArrays[k] = -1;
        }
        for (int j = 0; j < bundles.length; j++) {
            for (int i = 1; i <= amount; i++) {
                if (i >= bundles[j] && dpArrays[i - bundles[j]] + 1 < dpArrays[i]) {
                    dpArrays[i] = dpArrays[i - bundles[j]] + 1;
                    reverseArrays[i] = j;
                }
            }
        }
        result = String.valueOf(dpArrays[amount]);
        result = result + "/" + calculateTheCombination(reverseArrays, bundles);
        return result;
    }

    private String calculateTheCombination(int[] reverseArrays, int[] bundles) {
        StringBuilder result = new StringBuilder();
        if (reverseArrays[reverseArrays.length - 1] == -1) {
            return "-1";
        }
        int start = reverseArrays.length - 1;
        while (start != 0) {
            int j = reverseArrays[start];
            result.append(bundles[j]).append(" ");
            start = start - bundles[j];
        }
        result = new StringBuilder(result.substring(0, result.length() - 1));
        return result.toString();
    }

    public Order calculateTotalPrices(@NonNull Order order) {
        for (OrderItems item : order.getOrderItemsList()) {
            item.setBundleList(addBundleList(item.getMinimalCase()));
            item.setTotalAmount(addTotalAmount(item.getMinimalCase()));
            item.setPriceList(addPriceList(item.getBundleList(), item));
            item.setTotalSpend(addTotalPrice(item.getPriceList()));
        }
        return order;
    }

    private List<String> addBundleList(String input) {
        List<String> resultList = new ArrayList<>();
        int count = 1;
        String[] inputArray = input.split(empty);
        String temp;
        for (int i = 1; i < inputArray.length; i++) {
            if (!inputArray[i].equals(inputArray[i - 1])) {
                temp = count + times + inputArray[i - 1];
                resultList.add(temp);
                count = 1;
            } else {
                count++;
            }
            if (i == inputArray.length - 1) {
                temp = count + times + inputArray[i];
                resultList.add(temp);
            }
        }
        if (inputArray.length == 1) {
            temp = "1" + times + input;
            resultList.add(temp);
        }
        return resultList;
    }

    private String addTotalAmount(String input) {
        String[] temp = input.split(empty);
        int result = 0;
        for (String data : temp) {
            result += Integer.parseInt(data);
        }
        return result + "";
    }

    private List<String> addPriceList(List<String> inputCase, OrderItems items) {
        List<String> resultList = new ArrayList<>();
        for (String input : inputCase) {
            String[] cases = input.split(times);
            double tempPrice = items.getBundleAndPriceMap().get(Integer.valueOf(cases[2]));
            String temp = multiply(cases[0], tempPrice);
            resultList.add(temp);
        }
        return resultList;
    }

    private String multiply(String amount, double price) {
        return (Integer.parseInt(amount) * price) + "";
    }

    private String addTotalPrice(List<String> priceList) {
        return priceList.stream().mapToDouble(Double::valueOf).sum() + "";
    }

}
