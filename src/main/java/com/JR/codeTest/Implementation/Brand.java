package com.JR.codeTest.Implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.logging.Logger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    private Logger log = Logger.getLogger("InfoLogging");
//    final private String[] bundles = {"3", "6", "9"};
    private String[] bundles;

    private String name;
    //    private String[] bundles;
    private String amount;
    private int optimiseNumber;
    private String optimiseCombination;

//    public void calculate() {
//        log.warning("The input contains not existing brand category.");
////        Log.info("The input contains not existing brand category.");
//    }

    public void calculateMinimalNumberAndCases() {
        AlgorithmImplement algorithmImplement = new AlgorithmImplement();
        String temporary = algorithmImplement.order(getAmount(), getBundles());
        String[] temp = temporary.split(" / ");
        setOptimiseNumber(Integer.valueOf(temp[0]));
        setOptimiseCombination(temp[1]);
//        System.out.println(getOptimiseNumber());
    }

    public void printOutput(){
        log.warning("Input data exists non-defined brand");
    }
}
