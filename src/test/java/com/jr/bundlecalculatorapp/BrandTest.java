package com.jr.bundlecalculatorapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrandTest {
    final Brand brandImg = Brand.IMG;
    final Brand brandFlac = Brand.FLAC;
    final Brand brandVid = Brand.VID;

    @Test
    void calculateOptimisedCasesTestOfIMG() {
        String amount = "15";
        String realResult = brandImg.calculateOptimisedCases(amount,brandImg);
        String expectedResult = "1:10 1:5";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void calculateOptimisedCasesTestOfFLAC() {
        String amount = "788";
        String realResult = brandFlac.calculateOptimisedCases(amount,brandFlac);
        String expectedResult = "87:9 1:6";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void calculateOptimisedCasesTestOfVID() {
        String amount = "586";
        String realResult = brandVid.calculateOptimisedCases(amount,brandVid);
        String expectedResult = "64:9 2:5";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void calculateOptimisedCasesTestOfIMGWithNegative() {
        String amount = "-2";
        String realResult = brandImg.calculateOptimisedCases(amount,brandImg);
        String expectedResult = "-1";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void calculateOptimisedCasesTestOfFLACWithNegative() {
        String amount = "-8";
        String realResult = brandFlac.calculateOptimisedCases(amount,brandFlac);
        String expectedResult = "-1";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void calculateOptimisedCasesTestOfVIDWithNegative() {
        String amount = "-1588";
        String realResult = brandImg.calculateOptimisedCases(amount,brandImg);
        String expectedResult = "-1";
        Assertions.assertEquals(expectedResult,realResult);
    }

    @Test
    void parseOutputTestAllBrandsPositive() {
        String amount = "1:10 1:5";
        String expectedResultImg = "1:10:800.0 1:5:450.0 /IMG:15:$1250.0";
        String realResultImg = brandImg.parseOutput(amount,brandImg);

        amount = "1:9 1:6";
        String expectedResultFlac = "1:9:1147.5 1:6:810.0 /FLAC:15:$1957.5";
        String realResultFlac = brandFlac.parseOutput(amount,brandFlac);

        amount = "2:5 1:3";
        String expectedResultVid = "2:5:1800.0 1:3:570.0 /VID:13:$2370.0";
        String realResultVid = brandVid.parseOutput(amount,brandVid);
        Assertions.assertAll(
                () ->assertEquals(expectedResultImg,realResultImg),
                () ->assertEquals(expectedResultFlac,realResultFlac),
                () ->assertEquals(expectedResultVid,realResultVid)
        );
    }

    @Test
    void parseOutputTestBrandsImgPositive() {
        String amount = "1:6 1:5";
        String expectedResultImg = "-1";
        String realResultImg = brandImg.parseOutput(amount,brandImg);
        Assertions.assertEquals(expectedResultImg,realResultImg);
    }

    @Test
    void parseOutputTestBrandsFlacPositive() {
        String amount = "1:11 1:6";
        String expectedResultFlac = "-1";
        String realResultFlac = brandFlac.parseOutput(amount,brandFlac);
        Assertions.assertEquals(expectedResultFlac,realResultFlac);
    }

    @Test
    void parseOutputTestBrandsVidPositive() {
        String amount = "1:8";
        String expectedResultVid = "-1";
        String realResultVid = brandVid.parseOutput(amount,brandVid);
        Assertions.assertEquals(expectedResultVid,realResultVid);
    }
}