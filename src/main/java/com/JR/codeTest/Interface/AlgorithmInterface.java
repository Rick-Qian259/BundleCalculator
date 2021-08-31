package com.JR.codeTest.Interface;

import lombok.NonNull;

public interface AlgorithmInterface {

    /**
     * Process the input amount.
     * @param amount
     * @param bundles
     * @return the minimal number of bundles and its' specific case.
     */
    public String order(@NonNull String amount, @NonNull String[] bundles);

    /**
     * Calculate the minimal number.
     * @param amount
     * @param prices
     * @return the minimal number.
     */
    public String calculateTheOptimiseNumbers(int amount, int[] prices);

    /**
     * Find the specific cases.
     * @param reverseArrays
     * @param bundles
     * @return the specific cases.
     */
    public String calculateTheCombination(int[] reverseArrays, int[] bundles);
}
