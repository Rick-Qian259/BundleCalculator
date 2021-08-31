package com.JR.codeTest.Implementation;

public class Main {

    public static void main(String[] args) {
        String input = "10 IMG\n" + "15 FLAC\n" + "13 VID\n";
        OrderProcess orderProcess = new OrderProcess();
        orderProcess.processOrder(input);
    }
}
