package com.jr.bundlecalculatorapp;

import lombok.NonNull;

import java.util.Arrays;
import java.util.logging.Logger;

//@Slf4j
public class Algorithm {

    private final Logger log = Logger.getLogger("InfoLogging");

    /**
     * This method will calculate the optimised combination of each bundle,
     * and parse that into the specific format.
     *
     * @param amount The brand amount
     * @param bundles The brand bundles
     * @return a String, format likes "2:5 1:3".
     * For example, input 13, {3,5}, the minimal case is 5 5 3, so parse as 2:5 1:3.
     */
    public String order(@NonNull String amount, int[] bundles) {
        String result;

        int moneyInt = Integer.parseInt(amount);
        if (!validationInput(moneyInt, bundles)) {
            log.warning("Error! The amount or bundle values cannot less than 1.");
            return "-1";
        }
        result = calculateTheOptimiseNumbers(moneyInt, bundles);

//      if the amount cannot be divided completely by bundles, such as 7 is Video' input, and its' bundles are 3,5,9.
//      Each time it should plus one for input amount, until the input can be divided completely by bundles.
        while (result.split("/")[0].equals(String.valueOf(Integer.MAX_VALUE - 1))) {
            result = calculateTheOptimiseNumbers(moneyInt ++, bundles);
        }
        return parseNumber(result.split("/")[1]);
    }

    private boolean validationInput(int amount, int[] bundles) {
        return (amount > 0) && (Arrays.stream(bundles).noneMatch(x -> x < 1));
    }

    //    input: 5 5 3
    //    output: 2:5 1:3
    private String parseNumber(String input) {
        int count = 1;
        String[] inputArray = input.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 1; i < inputArray.length; i++) {
            if (!inputArray[i].equals(inputArray[i - 1])) {
                result.append(count).append(":").append(inputArray[i - 1]).append(" ");
//                System.out.println(count+":"+inputArray[i-1]);
                count = 1;
            } else {
                count++;
            }
            if (i == inputArray.length - 1) {
                result.append(count).append(":").append(inputArray[i]);
//                System.out.println(count+":"+inputArray[i]);
            }
        }
        if (inputArray.length == 1) {
            result = new StringBuilder("1:" + input);
        }
        return result.toString();
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

}
