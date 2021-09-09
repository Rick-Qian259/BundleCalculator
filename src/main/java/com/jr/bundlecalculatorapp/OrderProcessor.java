package com.jr.bundlecalculatorapp;


import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@NoArgsConstructor
public class OrderProcessor {
    private final Logger log = Logger.getLogger("InfoLogging");

    /**
     * process the input String, and calculate the optimised cases, then add these cases into a String list
     *
     *
     * @param input
     * @return
     */
    public List<String> processInputData(String input) {
        List<String> inputData = Arrays.asList(input.split("\n"));
        List<String> resultList = new ArrayList<>();
        inputData.forEach(data -> {
            String amount = data.split(" ")[0];
            String brandName = data.split(" ")[1];
            if (isInEnum(brandName)) {
                Brand brand = Brand.valueOf(brandName);
                String tempStr = brand.calculateOptimisedCases(amount, brand);
                String tempStr2 = brand.parseOutput(tempStr,brand);
                if(tempStr2.equals("-1")){
                    log.warning("An error occurred because it the algorithm parses into an bundle format which is different with the brand bundles!");
                    System.exit(1);
                }
                resultList.add(tempStr2);
            } else {
                log.warning("An error occurred because we do not have a brand: '" + brandName +"'!");
                System.exit(1);
            }
        });
        return resultList;
    }

//  check whether the input brand name is stored in the program,
//  if not, return false and program will exit.
    private boolean isInEnum(String input) {
        for (Brand brand : Brand.values()) {
            if (input.equals(brand.name())) {
                return true;
            }
        }
        return false;
    }

//    10 IMG $800
//    1 x 10 $800
    public void printOutput(List<String> input) {
        input.forEach( data->{
            String[] firstLineData = data.split("/")[1].split(":");
            String[] remainLineData = data.split("/")[0].split(" ");
            log.info(firstLineData[1] + " " + firstLineData[0] + " " +firstLineData[2]);
            for(String remain: remainLineData) {
                String[] innerRemain = remain.split(":");
                log.info(innerRemain[0] + " * " + innerRemain[1] + " $" + innerRemain[2]);
            }
        });
    }

}
