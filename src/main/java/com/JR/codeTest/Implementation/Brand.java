package com.JR.codeTest.Implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.logging.Logger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    private Logger log = Logger.getLogger("InfoLogging");
    private String[] bundles;

    private String name;
    private String amount;
    private int optimiseNumber;
    private String optimiseCombination;

    public void calculateMinimalNumberAndCases() {
        AlgorithmImplement algorithmImplement = new AlgorithmImplement();
        String temporary = algorithmImplement.order(getAmount(), getBundles());
        String[] temp = temporary.split(" / ");
        setOptimiseNumber(Integer.valueOf(temp[0]));
        setOptimiseCombination(temp[1]);
    }

    public void printOutput() {
        log.warning("Input data exists non-defined brand");
    }
}
