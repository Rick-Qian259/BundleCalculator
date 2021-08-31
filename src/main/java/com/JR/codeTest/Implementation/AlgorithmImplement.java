package com.JR.codeTest.Implementation;

import com.JR.codeTest.Interface.AlgorithmInterface;
import lombok.NonNull;

import java.util.Arrays;
import java.util.logging.Logger;

public class AlgorithmImplement implements AlgorithmInterface {
    private static Logger log = Logger.getLogger("InfoLogging");

    /**
     * This method returns a string for each brand's children.
     * @param amount
     * @param bundles
     * @return a String, format likes "2 / 5 3", the number before slash is the minimal numbers of bundles.
     * THe numbers after slash are all cases.
     */
    public String order(@NonNull String amount, @NonNull String[] bundles) {
        String result = null;
        int moneyInt = Integer.parseInt(amount);
        int[] bundlesInt = Arrays.stream(bundles).mapToInt(Integer::parseInt).toArray();
        result = calculateTheOptimiseNumbers(moneyInt, bundlesInt);

//      if the amount cannot be divided completely by bundles, such as 7 is Video' input, and its' bundles are 3,5,9.
//      Each time it should plus one for input amount, until the input can be divided completely by bundles.
        while (result == null || result.split(" ")[0].equals(String.valueOf(Integer.MAX_VALUE - 1))) {
            result = calculateTheOptimiseNumbers(moneyInt + 1, bundlesInt);
        }
        return result;
    }

    /**
     * Calculate the minimal number of bundles.
     * @param amount
     * @param bundles
     * @return the minimal number of bundles
     */
    public String calculateTheOptimiseNumbers(int amount, int[] bundles) {
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
        result = result + " /" + calculateTheCombination(reverseArrays, bundles);
        return result;
    }

    /**
     * According to the minimal number, to calculate the specific cases.
     * @param reverseArrays
     * @param bundles
     * @return
     */
    public String calculateTheCombination(int[] reverseArrays, int[] bundles) {
        String result = "";
        if (reverseArrays[reverseArrays.length - 1] == -1) {
            System.out.println("No Solution Possible");
            return "-1";
        }
        int start = reverseArrays.length - 1;
        while (start != 0) {
            int j = reverseArrays[start];
            result = result + " " + bundles[j];
            start = start - bundles[j];
        }
        return result;
    }


}
