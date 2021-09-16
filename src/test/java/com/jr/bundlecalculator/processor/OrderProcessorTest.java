package com.jr.bundlecalculator.processor;

import com.jr.bundlecalculator.entity.Order;
import com.jr.bundlecalculator.entity.OrderItems;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessorTest {

    OrderProcessor orderProcessor = new OrderProcessor();

    @Test
    void testConvertInputDataToOrderObject() {
        Order expectedOrder = new Order();
        String inputData = "10 IMG\n" + "15 FLAC\n" + "13 VID\n";
        Order realOrder = orderProcessor.convertInputDataToOrderObject(inputData);

        OrderItems orderItemsOne = new OrderItems();
        orderItemsOne = assignOrderItems(orderItemsOne, "IMG", new int[] {5,10},
                new double[] {450, 800}, "10");
        OrderItems orderItemsTwo = new OrderItems();
        orderItemsTwo = assignOrderItems(orderItemsTwo, "FLAC", new int[] {3,6,9},
                new double[] {427.5, 810, 1147.5}, "15");
        OrderItems orderItemsThree = new OrderItems();
        orderItemsThree = assignOrderItems(orderItemsThree, "VID", new int[] {3,5,9},
                new double[] {570, 900, 1530}, "13");
        expectedOrder.addOrderItems(orderItemsOne);
        expectedOrder.addOrderItems(orderItemsTwo);
        expectedOrder.addOrderItems(orderItemsThree);

        assertEquals(expectedOrder,realOrder);
    }

    @Test
    void testConvertInputDataToOrderObjectDifferentAmounts() {
        Order expectedOrder = new Order();
        String inputData = "188 IMG\n" + "152 FLAC\n" + "139 VID\n";
        Order realOrder = orderProcessor.convertInputDataToOrderObject(inputData);

        OrderItems orderItemsOne = new OrderItems();
        orderItemsOne = assignOrderItems(orderItemsOne, "IMG", new int[] {5,10},
                new double[] {450, 800}, "188");
        OrderItems orderItemsTwo = new OrderItems();
        orderItemsTwo = assignOrderItems(orderItemsTwo, "FLAC", new int[] {3,6,9},
                new double[] {427.5, 810, 1147.5}, "152");
        OrderItems orderItemsThree = new OrderItems();
        orderItemsThree = assignOrderItems(orderItemsThree, "VID", new int[] {3,5,9},
                new double[] {570, 900, 1530}, "139");
        expectedOrder.addOrderItems(orderItemsOne);
        expectedOrder.addOrderItems(orderItemsTwo);
        expectedOrder.addOrderItems(orderItemsThree);

        assertEquals(expectedOrder,realOrder);
    }


    @Test
    void testConvertInputDataToOrderObjectWrongBrandName() {
        Order expectedOrder = new Order();
        String inputData = "10 img\n" + "15 FLAC\n" + "13 VID\n";
        Order realOrder = orderProcessor.convertInputDataToOrderObject(inputData);

        OrderItems orderItemsOne = new OrderItems();
        orderItemsOne = assignOrderItems(orderItemsOne, "IMG", new int[] {5,10},
                new double[] {450, 800}, "10");
        OrderItems orderItemsTwo = new OrderItems();
        orderItemsTwo = assignOrderItems(orderItemsTwo, "FLAC", new int[] {3,6,9},
                new double[] {427.5, 810, 1147.5}, "15");
        OrderItems orderItemsThree = new OrderItems();
        orderItemsThree = assignOrderItems(orderItemsThree, "VID", new int[] {3,5,9},
                new double[] {570, 900, 1530}, "13");
        expectedOrder.addOrderItems(orderItemsOne);
        expectedOrder.addOrderItems(orderItemsTwo);
        expectedOrder.addOrderItems(orderItemsThree);

        assertNotEquals(expectedOrder, realOrder);
    }

    @Test
    void testConvertInputDataToOrderObjectNegativeAmount() {
        Order expectedOrder = new Order();
        String inputData = "-10 IMG\n" + "15 FLAC\n" + "13 VID\n";
        Order realOrder = orderProcessor.convertInputDataToOrderObject(inputData);

        OrderItems orderItemsOne = new OrderItems();
        orderItemsOne = assignOrderItems(orderItemsOne, "IMG", new int[] {5,10},
                new double[] {450, 800}, "10");
        OrderItems orderItemsTwo = new OrderItems();
        orderItemsTwo = assignOrderItems(orderItemsTwo, "FLAC", new int[] {3,6,9},
                new double[] {427.5, 810, 1147.5}, "15");
        OrderItems orderItemsThree = new OrderItems();
        orderItemsThree = assignOrderItems(orderItemsThree, "VID", new int[] {3,5,9},
                new double[] {570, 900, 1530}, "13");
        expectedOrder.addOrderItems(orderItemsOne);
        expectedOrder.addOrderItems(orderItemsTwo);
        expectedOrder.addOrderItems(orderItemsThree);

        assertNotEquals(expectedOrder, realOrder);
    }

    @Test
    void testConvertInputDataToOrderObjectNonNumberAmount() {
        Order expectedOrder = new Order();
        String inputData = "ten IMG\n" + "15 FLAC\n" + "13 VID\n";
        Order realOrder = orderProcessor.convertInputDataToOrderObject(inputData);

        OrderItems orderItemsOne = new OrderItems();
        orderItemsOne = assignOrderItems(orderItemsOne, "IMG", new int[] {5,10},
                new double[] {450, 800}, "10");
        OrderItems orderItemsTwo = new OrderItems();
        orderItemsTwo = assignOrderItems(orderItemsTwo, "FLAC", new int[] {3,6,9},
                new double[] {427.5, 810, 1147.5}, "15");
        OrderItems orderItemsThree = new OrderItems();
        orderItemsThree = assignOrderItems(orderItemsThree, "VID", new int[] {3,5,9},
                new double[] {570, 900, 1530}, "13");
        expectedOrder.addOrderItems(orderItemsOne);
        expectedOrder.addOrderItems(orderItemsTwo);
        expectedOrder.addOrderItems(orderItemsThree);

        assertNotEquals(expectedOrder, realOrder);
    }

    private OrderItems assignOrderItems (OrderItems orderItems, String brandName, int[] bundle, double[] prices, String amount) {
        Map<Integer,Double> tempMap = new HashMap<>();

        for (int i = 0; i < bundle.length; i++) {
            tempMap.put(bundle[i], prices[i]);
        }

        orderItems.setBrandName(brandName);
        orderItems.setBundle(bundle);
        orderItems.setAmount(amount);
        orderItems.setBundleAndPriceMap(tempMap);
        return orderItems;
    }
}