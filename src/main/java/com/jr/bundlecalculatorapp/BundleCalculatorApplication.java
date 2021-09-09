package com.jr.bundlecalculatorapp;

import java.util.List;

public class BundleCalculatorApplication {
    public static void main(String[] args) {
        List<String> outputList;
        String input = "10 IMg\n" + "15 FLAC\n" + "13 VID\n";

        OrderProcessor orderProcessor = new OrderProcessor();
        outputList = orderProcessor.processInputData(input);
        orderProcessor.printOutput(outputList);
    }

}
