package com.jr.bundlecalculator.brand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.logging.Logger;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Brand {
    IMG(new int[]{5, 10}, new double[]{450, 800}),
    FLAC(new int[]{3, 6, 9}, new double[]{427.5, 810, 1147.5}),
    VID(new int[]{3, 5, 9}, new double[]{570, 900, 1530});

    private final Logger log = Logger.getLogger("InfoLogging");
    private int[] priceBundle;
    private double[] priceValue;

}
