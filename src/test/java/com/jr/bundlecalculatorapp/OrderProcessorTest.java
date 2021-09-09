package com.jr.bundlecalculatorapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class OrderProcessorTest {

    final OrderProcessor orderProcessor = new OrderProcessor();

    @Test
    void processInputDataTestBasicCase() {
        String input = "10 IMG\n" + "15 FLAC\n" + "13 VID\n";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1:10:800.0 /IMG:10:$800.0");
        expectedResult.add("1:9:1147.5 1:6:810.0 /FLAC:15:$1957.5");
        expectedResult.add("2:5:1800.0 1:3:570.0 /VID:13:$2370.0");
        List<String> realResult = orderProcessor.processInputData(input);
        Assertions.assertEquals(expectedResult,realResult);
    }

//    the 9 IMG should be calculate into 10, because the nearest bundle to 9 is 10.
    @Test
    void processInputDataTestIncreaseIMGBrandAmount() {
        String input = "9 IMG\n" + "15 FLAC\n" + "13 VID\n";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1:10:800.0 /IMG:10:$800.0");
        expectedResult.add("1:9:1147.5 1:6:810.0 /FLAC:15:$1957.5");
        expectedResult.add("2:5:1800.0 1:3:570.0 /VID:13:$2370.0");
        List<String> realResult = orderProcessor.processInputData(input);
        Assertions.assertEquals(expectedResult,realResult);
    }


    //    the 10 FLAC should be calculate into 12, because for the [3,6,9], only 6+6 is the nearest case for 10.
    @Test
    void processInputDataTestIncreaseFLACBrandAmount() {
        String input = "10 IMG\n" + "10 FLAC\n" + "13 VID\n";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1:10:800.0 /IMG:10:$800.0");
        expectedResult.add("2:6:1620.0 /FLAC:12:$1620.0");
        expectedResult.add("2:5:1800.0 1:3:570.0 /VID:13:$2370.0");
        List<String> realResult = orderProcessor.processInputData(input);
        Assertions.assertEquals(expectedResult,realResult);
    }

    //    the 7 VID should be calculate into 8, because for the [3,5,9], only 5+3 is the nearest case for 7.
    @Test
    void processInputDataTestIncreaseVIDBrandAmount() {
        String input = "10 IMG\n" + "15 FLAC\n" + "7 VID\n";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1:10:800.0 /IMG:10:$800.0");
        expectedResult.add("1:9:1147.5 1:6:810.0 /FLAC:15:$1957.5");
        expectedResult.add("1:5:900.0 1:3:570.0 /VID:8:$1470.0");
        List<String> realResult = orderProcessor.processInputData(input);
        Assertions.assertEquals(expectedResult,realResult);
    }

//    IMG 9 -> 10, FLAC 10 -> 12, VID 7 -> 8
    @Test
    void processInputDataTestIncreaseAllBrandsAmount(){
        String input = "9 IMG\n" + "10 FLAC\n" + "7 VID\n";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1:10:800.0 /IMG:10:$800.0");
        expectedResult.add("2:6:1620.0 /FLAC:12:$1620.0");
        expectedResult.add("1:5:900.0 1:3:570.0 /VID:8:$1470.0");
        List<String> realResult = orderProcessor.processInputData(input);
        Assertions.assertEquals(expectedResult,realResult);
    }

//    this be tested method will receive a String list from
//    a return list of the method processInputData(),
//    therefore, if the processInputData() method passes all the test cases,
//    the printOutput() method would receive the correct format of information,
//    and this method would not occur an error.
    @Test
    void printOutputTest() {
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("1:10:800.0 /IMG:10:$800.0");
        expectedResult.add("2:6:1620.0 /FLAC:12:$1620.0");
        expectedResult.add("1:5:900.0 1:3:570.0 /VID:8:$1470.0");
        orderProcessor.printOutput(expectedResult);
    }
}