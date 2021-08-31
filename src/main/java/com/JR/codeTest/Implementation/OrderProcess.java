package com.JR.codeTest.Implementation;

import com.JR.codeTest.Interface.OrderProcessInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class OrderProcess implements OrderProcessInterface {
    private final Logger logger = Logger.getLogger("InfoLogging");
    private final List<String> brandArraylist = new ArrayList<>();


    public void initialiseBrandList() {
        brandArraylist.add("IMG");
        brandArraylist.add("FLAC");
        brandArraylist.add("VID");
    }

    public void processOrder(String input) {
        initialiseBrandList();
        processInputData(input);
    }

    /**
     * process the input String, use that String for each brand's children to calculate and print output.
     *
     * @param input
     */
    public void processInputData(String input) {
        List<String> inputData = Arrays.asList(input.split("\n"));
        inputData.forEach(data -> {
            String amount = data.split(" ")[0];
            String brandName = data.split(" ")[1];
            if (brandArraylist.contains(brandName)) {
                Brand brand = new Brand();
                if (data.contains("IMG")) brand = new Image(amount, brandName);
                else if (data.contains("FLAC")) brand = new Audio(amount, brandName);
                else if (data.contains("VID")) brand = new Video(amount, brandName);
                brand.calculateMinimalNumberAndCases();
                brand.printOutput();
            } else {
                logger.warning("The input contains not existing brand category.");
            }
        });
    }

}
