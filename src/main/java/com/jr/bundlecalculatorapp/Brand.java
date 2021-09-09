package com.jr.bundlecalculatorapp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.logging.Logger;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Brand {
    IMG(1, new int[]{5, 10}, new double[]{450, 800}),
    FLAC(2, new int[]{3, 6, 9}, new double[]{427.5, 810, 1147.5}),
    VID(3, new int[]{3, 5, 9}, new double[]{570, 900, 1530});

    private final Logger log = Logger.getLogger("InfoLogging");
    private int priceSequence;
    private int[] priceBundle;
    private double[] priceValue;

    //   2:5 1:3
    public String calculateOptimisedCases(String amount, Brand brand) {
        Algorithm algorithm = new Algorithm();
        return algorithm.order(amount, brand.getPriceBundle());
    }

    //      13 VID $2370
//      2 x 5 $1800
//      1 x 3 $570
//      1:10
    public String parseOutput(String combination, Brand brand) {
        StringBuilder result = new StringBuilder();
        String[] inputArray = combination.split(" ");
        if (checkCombination(inputArray, brand)) {
            log.warning("The input combination has values excluded the bundles!");
            return "-1";
        }
        for (String input : inputArray) {
            String[] singleStr = input.split(":");
            int index = findBundleIndex(singleStr[1], brand);
            if (index != -1) {
                double price = calculateThePrice(singleStr[0], brand.getPriceValue()[index]);
                result.append(input).append(":").append(price).append(" ");
            } else {
                log.warning("The input data has an incorrect format, please check the input data!");
            }
        }
        result = new StringBuilder(appendTotalPrice(result.toString(), brand));
        return result.toString();
    }

    private boolean checkCombination(String[] inputArray, Brand brand) {
        int count = 0;
        for (String input : inputArray) {
            for (int bundle : brand.priceBundle) {
                if (input.split(":")[1].equals(bundle + "")) {
                    count++;
                    break;
                }
            }
        }
        return !(count == inputArray.length);
    }

    //    input: "3" 50.0
    //    output 150.0
    private double calculateThePrice(String amount, double price) {
        int amountInt = Integer.parseInt(amount);
        return amountInt * price;
    }

    private int findBundleIndex(String inputBundle, Brand brand) {
        for (int i = 0; i < brand.priceBundle.length; i++) {
            if (inputBundle.equals(brand.priceBundle[i] + "")) {
                return i;
            }
        }
        return -1;
    }

    //    1:9:$1147.5 1:6:$810.0
    private String appendTotalPrice(String input, Brand brand) {
        String result;
        String[] singleInput = input.split(" ");
        int totalNumber = 0;
        double totalPrice = 0;
        for (String sing : singleInput) {
            totalNumber += (Integer.parseInt(sing.split(":")[0])) * (Integer.parseInt(sing.split(":")[1]));
            totalPrice += Double.parseDouble(sing.split(":")[2]);
        }
//        1:9:$1147.50 1:6:$810 | FLAC:15:$1957.50
        result = input + "/" + brand.name() + ":" + totalNumber + ":$" + totalPrice;
        return result;
    }

}
