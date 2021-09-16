package com.jr.bundlecalculator;

import com.jr.bundlecalculator.algorithm.Algorithm;
import com.jr.bundlecalculator.entity.Order;
import com.jr.bundlecalculator.processor.OrderProcessor;

import java.util.logging.Logger;

public class BundleCalculatorApplication {
    private static final Logger log = Logger.getLogger("InfoLogging");

    public static void main(String[] args) {

        OrderProcessor orderProcessor = new OrderProcessor();
        Algorithm algorithm = new Algorithm();

        String inputData = "9 IMG\n" + "15 FLAC\n" + "13 VID\n";
        Order order = orderProcessor.convertInputDataToOrderObject(inputData);
        order = algorithm.calculateNumberAndCase(order);
        order = algorithm.calculateTotalPrices(order);
        log.info(order.toString());
    }
}
