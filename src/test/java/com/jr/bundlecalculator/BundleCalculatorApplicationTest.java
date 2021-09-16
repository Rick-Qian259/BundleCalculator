package com.jr.bundlecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BundleCalculatorApplicationTest {

    BundleCalculatorApplication bundleCalculatorApplication = new BundleCalculatorApplication();
    @Test
    void testMain() {
        BundleCalculatorApplication.main(new String[]{"0"});
    }
}