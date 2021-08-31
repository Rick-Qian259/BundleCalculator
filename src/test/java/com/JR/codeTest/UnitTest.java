package com.JR.codeTest;

import com.JR.codeTest.Implementation.Audio;
import com.JR.codeTest.Implementation.Image;
//import com.JR.codeTest.Implementation.OrderProcess;
import com.JR.codeTest.Implementation.Video;
//import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UnitTest {

//    @DisplayName("Test MessageService.get()")
//    @Test
//    void testGet() {
//        Assertions.assertEquals("Hello Junit5", MessageService.get());
//    }

    String amount = "10";
    String brandName = "IMG";
    int[] testData = {10};


    @DisplayName("Test img output with input 10")
    @Test
    void testIMGInput10(){
        Image image = new Image(amount, brandName);
        Assertions.assertEquals("800.0\n" + "1 * 10 $800.0\n", image.calculateMoney(testData));
    }

    @DisplayName("Test img output with input 15")
    @Test
    void testIMGInput15(){
        amount = "15";
        brandName = "IMG";
        int[] testData = {10,5};
        Image image = new Image(amount, brandName);
        Assertions.assertEquals("1250.0\n" + "1 * 5 $450.0\n" + "1 * 10 $800.0\n" , image.calculateMoney(testData));
    }

    @DisplayName("Test img output with input 8")
    @Test
    void testIMGInput8(){
        amount = "8";
        brandName = "IMG";
        int[] testData = {10};
        Image image = new Image(amount, brandName);
        Assertions.assertEquals("800.0\n" + "1 * 10 $800.0\n" , image.calculateMoney(testData));
    }

    @DisplayName("Test video output with input 13")
    @Test
    void testVideoInput13(){
        amount = "13";
        brandName = "VID";
        int[] testData = {3,5,5};
        Video video = new Video(amount, brandName);
        Assertions.assertEquals("2370.0\n" + "1 * 3 $570.0\n"+ "2 * 5 $1800.0\n", video.calculateMoney(testData));
    }

    @DisplayName("Test video output with input 1")
    @Test
    void testVideoInput1(){
        amount = "1";
        brandName = "VID";
        int[] testData = {3};
        Video video = new Video(amount, brandName);
        Assertions.assertEquals("570.0\n" + "1 * 3 $570.0\n" , video.calculateMoney(testData));
    }

    @DisplayName("Test video output with input 9")
    @Test
    void testVideoInput9(){
        amount = "9";
        brandName = "VID";
        int[] testData = {9};
        Video video = new Video(amount, brandName);
        Assertions.assertEquals("1530.0\n" + "1 * 9 $1530.0\n" , video.calculateMoney(testData));
    }


    @DisplayName("Test Audio output with input 15")
    @Test
    void testAudioInput15(){
        amount = "15";
        brandName = "FLAC";
        int[] testData = {6,9};
        Audio audio = new Audio(amount, brandName);
        Assertions.assertEquals("1957.5\n" + "1 * 6 $810.0\n"+ "1 * 9 $1147.5\n", audio.calculateMoney(testData));
    }

    @DisplayName("Test Audio output with input 18")
    @Test
    void testAudioInput18(){
        amount = "18";
        brandName = "FLAC";
        int[] testData = {9,9};
        Audio audio = new Audio(amount, brandName);
        Assertions.assertEquals("2295.0\n" + "2 * 9 $2295.0\n", audio.calculateMoney(testData));
    }

    @DisplayName("Test Audio output with input 1")
    @Test
    void testAudioInput1(){
        amount = "1";
        brandName = "FLAC";
        int[] testData = {3};
        Audio audio = new Audio(amount, brandName);
        Assertions.assertEquals("427.5\n" + "1 * 3 $427.5\n", audio.calculateMoney(testData));
    }

//    @DisplayName("Test Audio output with input 1")
//    @Test
//    void testOrder(){
//        String input = "10 IMG\n" + "15 FLAC\n" + "13 VID\n";
//        OrderProcess or = new OrderProcess();
////        Assertions.assertEquals(or.processOrder(input));
//    }
}
