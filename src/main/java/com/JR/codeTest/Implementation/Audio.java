package com.JR.codeTest.Implementation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Audio extends Brand {
    final private String[] childrenBundles = {"3", "6", "9"};

    private Map<String, Double> bundlesAndPrice = new HashMap<String, Double>();

    void initialMap() {
        bundlesAndPrice.put("3", 427.50);
        bundlesAndPrice.put("6", 810.0);
        bundlesAndPrice.put("9", 1147.50);
    }

    public Audio(String amount, String name) {
        setName(name);
        setAmount(amount);
        setBundles(childrenBundles);
        initialMap();
    }

    public Audio(String name) {
        setName(name);
    }

    @Override
    public void printOutput() {
        int[] total = Arrays.stream(getOptimiseCombination().split(" ")).mapToInt(Integer::parseInt).toArray();
        int totalNumber = Arrays.stream(total).sum();
        String outputInformation = calculateMoney(total);
        outputInformation = totalNumber + " " + "FIAC $" +outputInformation;
        getLog().info(outputInformation);
    }

    public String calculateMoney(int[] total) {
        String result = "";
        Arrays.sort(total);
        int temp = total[0];
        int count = 1;
        double price = 0;
        double totalPrice = 0;
        for (int i = 1; i < total.length; i++) {
            if (temp == total[i]) {
                count++;
                if (i == total.length - 1) {
                    price = bundlesAndPrice.get(String.valueOf(temp));
                    result = result + count + " * " + temp + " $" + price * count + "\n";
                    totalPrice += price * count;
                }
            } else {
                price = bundlesAndPrice.get(String.valueOf(temp));
                result = result + count + " * " + temp + " $" + price * count + "\n";
                totalPrice += price * count;
                count = 1;
            }
            temp = total[i];
        }
        if(total.length ==1 || (total.length ==2  && total[0] != total[1])) {
            price = bundlesAndPrice.get(String.valueOf(temp));
            result = result + count + " * " + temp + " $" + price * count + "\n";
            totalPrice += price * count;
        }
        return totalPrice + "\n"+result;
    }

    //    "427.50","810",,"1147.50"
//    @Override
//    public void calculate() {
//        AlgorithmImplement algorithmImplement = new AlgorithmImplement();
//        String temporary = algorithmImplement.order(getAmount(), bundles);
//        String[] temp = temporary.split(" / ");
//        setOptimiseNumber(Integer.valueOf(temp[0]));
//        setOptimiseCombination(temp[1]);
//    }

}
