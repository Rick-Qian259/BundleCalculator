package com.jr.bundlecalculatorapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlgorithmTest {

    final Algorithm algorithm = new Algorithm();

    @Test
    void orderTestOneOutput() {
        String amount = "5";
        int[] bundles = {3,5};
        String realResult = algorithm.order(amount,bundles);
        String expectedResult = "1:5";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void orderTestTwoOutputs() {
        String amount = "13";
        int[] bundles = {3,5};
        String realResult = algorithm.order(amount,bundles);
        String expectedResult = "2:5 1:3";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void orderTestMoreOutputs() {
        String amount = "23";
        int[] bundles = {1,3,6,13};
        String realResult = algorithm.order(amount,bundles);
        String expectedResult ="1:13 1:6 1:3 1:1" ;
        Assertions.assertEquals(expectedResult,realResult);
    }

//    If the amount less than 1, tested method will return "-1" and log error information.
    @Test
    void orderTestNegativeAmount() {
        String amount = "-1";
        int[] bundles = {3,5};
        String realResult = algorithm.order(amount,bundles);
        String expectedResult = "-1";
        Assertions.assertEquals(expectedResult,realResult);
    }

//    If the bundle has values less than 1, tested method will return "-1" and log error information.
    @Test
    void orderTestNegativeBundles() {
        String amount = "4";
        int[] bundles = {-3,5};
        String realResult = algorithm.order(amount,bundles);
        String expectedResult = "-1";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void orderTestLargeInput() {
        String amount = "1234";
        int[] bundles = {3,6,9};
        String realResult = algorithm.order(amount,bundles);
        String expectedResult = "136:9 2:6";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void orderTestVeryLargeInput() {
        String amount = "12345678";
        int[] bundles = {3,6,9};
        String realResult = algorithm.order(amount,bundles);
        String expectedResult = "1371742:9";
        Assertions.assertEquals(expectedResult,realResult);
    }


}