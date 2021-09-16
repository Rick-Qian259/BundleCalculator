package com.jr.bundlecalculator.algorithm;

import com.jr.bundlecalculator.entity.Order;
import com.jr.bundlecalculator.entity.OrderItems;
import com.jr.bundlecalculator.processor.OrderProcessor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlgorithmTest {

    OrderProcessor orderProcessorCaseOne = new OrderProcessor();
    Algorithm algorithm = new Algorithm();
    OrderItems orderItemsOne;
    OrderItems orderItemsTwo;
    OrderItems orderItemsThree;

    @Test
    void testCalculateNumberAndCase() {
        String inputData = "10 IMG\n" + "15 FLAC\n" + "13 VID\n";
        Order realResultOrder = orderProcessorCaseOne.convertInputDataToOrderObject(inputData);
        realResultOrder = algorithm.calculateNumberAndCase(realResultOrder);

        Order expectedOrder = new Order();
        initialOrderItems(new int[][]{ {5, 10}, {3, 6, 9}, {3, 5, 9} }, new double[][] { {450, 800}, {427.5, 810, 1147.5}, {570, 900, 1530} }, new String[] { "10", "15", "13" });

        expectedOrder.addOrderItems(orderItemsOne);
        expectedOrder.addOrderItems(orderItemsTwo);
        expectedOrder.addOrderItems(orderItemsThree);

        assertEquals(expectedOrder, realResultOrder);
    }

    @Test
    void testCalculateNumberAndCaseDifferentAmount() {
//        String inputData = "188 IMG\n" + "155 FLAC\n" + "133 VID\n";
        String inputData = "9 IMG\n" + "15 FLAC\n" + "13 VID\n";
        Order realResultOrder = orderProcessorCaseOne.convertInputDataToOrderObject(inputData);
        realResultOrder = algorithm.calculateNumberAndCase(realResultOrder);

        Order expectedOrder = new Order();
        initialOrderItems(new int[][]{ {5, 10}, {3, 6, 9}, {3, 5, 9} }, new double[][] { {450, 800}, {427.5, 810, 1147.5}, {570, 900, 1530} }, new String[] { "9", "15", "13" });


        expectedOrder.addOrderItems(orderItemsOne);
        expectedOrder.addOrderItems(orderItemsTwo);
        expectedOrder.addOrderItems(orderItemsThree);

        assertEquals(expectedOrder, realResultOrder);
    }



    @Test
    void testCalculateTotalPrices() {
        String inputData = "10 IMG\n" + "15 FLAC\n" + "13 VID\n";
        Order realResultOrder = orderProcessorCaseOne.convertInputDataToOrderObject(inputData);
        realResultOrder = algorithm.calculateNumberAndCase(realResultOrder);
        realResultOrder = algorithm.calculateTotalPrices(realResultOrder);

        Order expectedOrder = new Order();
        initialOrderItems(new int[][]{ {5, 10}, {3, 6, 9}, {3, 5, 9} }, new double[][] { {450, 800}, {427.5, 810, 1147.5}, {570, 900, 1530} }, new String[] { "10", "15", "13" });
        addTotalPriceForOrderItems();

        expectedOrder.addOrderItems(orderItemsOne);
        expectedOrder.addOrderItems(orderItemsTwo);
        expectedOrder.addOrderItems(orderItemsThree);

        assertEquals(expectedOrder, realResultOrder);

    }

    private OrderItems assignOrderItemsWithNumberAndCases(OrderItems orderItems, String minimalNumber, String minimalCases) {
        orderItems.setMinimalNumber(minimalNumber);
        orderItems.setMinimalCase(minimalCases);
        return orderItems;
    }

    private OrderItems assignOrderItems(OrderItems orderItems, String brandName, int[] bundle, double[] prices, String amount) {
        Map<Integer, Double> tempMap = new HashMap<>();

        for (int i = 0; i < bundle.length; i++) {
            tempMap.put(bundle[i], prices[i]);
        }

        orderItems.setBrandName(brandName);
        orderItems.setBundle(bundle);
        orderItems.setAmount(amount);
        orderItems.setBundleAndPriceMap(tempMap);
        return orderItems;
    }

    private OrderItems assignOrderItemsTotalPrices(OrderItems orderItems, String totalSpend, String totalAmount, List<String> bundleList, List<String> priceList) {
        orderItems.setTotalSpend(totalSpend);
        orderItems.setTotalAmount(totalAmount);
        orderItems.setBundleList(bundleList);
        orderItems.setPriceList(priceList);

        return orderItems;
    }

//    int[][] price, double[][] bundle
    private void initialOrderItems(int[][] price, double[][] bundle,String[] amount) {
        orderItemsOne = new OrderItems();
        orderItemsOne = assignOrderItems(orderItemsOne, "IMG",price[0],
                bundle[0], amount[0]);
        orderItemsOne = assignOrderItemsWithNumberAndCases(orderItemsOne, "1", "10");

        orderItemsTwo = new OrderItems();
        orderItemsTwo = assignOrderItems(orderItemsTwo, "FLAC", price[1],
                bundle[1], amount[1]);
        orderItemsTwo = assignOrderItemsWithNumberAndCases(orderItemsTwo, "2", "9 6");

        orderItemsThree = new OrderItems();
        orderItemsThree = assignOrderItems(orderItemsThree, "VID", price[2],
                bundle[2], amount[2]);
        orderItemsThree = assignOrderItemsWithNumberAndCases(orderItemsThree, "3", "5 5 3");
    }

//    { {5, 10}, {3, 6, 9}, {3, 5, 9} }
//    { {450, 800}, {427.5, 810, 1147.5}, {570, 900, 1530} }
//    { "10", "15", "13" }

//    IMG(new int[]{5, 10}, new double[]{450, 800}),
//    FLAC(new int[]{3, 6, 9}, new double[]{427.5, 810, 1147.5}),
//    VID(new int[]{3, 5, 9}, new double[]{570, 900, 1530});

    private void addTotalPriceForOrderItems() {
        List<String> bundleListOne = Arrays.asList("1 * 10");
        List<String> bundleListTwo = Arrays.asList("1 * 9", "1 * 6");
        List<String> bundleListThree = Arrays.asList("2 * 5", "1 * 3");

        List<String> priceOne = Arrays.asList("800.0");
        List<String> priceTwo = Arrays.asList("1147.5", "810.0");
        List<String> priceThree = Arrays.asList("1800.0", "570.0");

        orderItemsOne = assignOrderItemsTotalPrices(orderItemsOne, "800.0", "10", bundleListOne, priceOne);
        orderItemsTwo = assignOrderItemsTotalPrices(orderItemsTwo, "1957.5", "15", bundleListTwo, priceTwo);
        orderItemsThree = assignOrderItemsTotalPrices(orderItemsThree, "2370.0", "13", bundleListThree, priceThree);
    }
}