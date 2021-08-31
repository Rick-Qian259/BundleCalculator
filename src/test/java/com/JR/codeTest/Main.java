package com.JR.codeTest;

import com.JR.codeTest.Implementation.Image;
//import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Main {
    //    private static Logger logger = Logger.getLogger("InfoLogging");
//
    Map<String, Function<String, Object>> actionMappings = new HashMap<>(); // Generics here? For demonstration purposes, they can be replaced with the types you need

    public static void main(String[] args) {
//        Main m = new Main();
//        m.ini();
//        m.use();
//       logger.info("Did not exist");
        int a = 13;
        int[] b = {3,5,9};
        int[] c = {5,9,9,3};
        Arrays.sort(c);
//        Arrays.stream(c).sorted();
//        Arrays.sort(c, (o1, o2) -> o2 - o1);
        int[] reverseArr = IntStream.rangeClosed(1, c.length).map(i -> c[c.length-i]).toArray();
        System.out.println(solve2(a,b));

        String s = null;
        System.out.println(s == null);
        s = "2147483646 / a";
        if(s.split(" ")[0].equals(String.valueOf(Integer.MAX_VALUE - 1))) System.out.println("a");
        if(s == null || s.split(" ")[0].equals(String.valueOf(Integer.MAX_VALUE - 1))) System.out.println("b");
//        char s = "2147483646";

    }

    static int solve2(int n, int[] coins) {
        int[] a = new int[n+1];
        for (int i = 0; i <= n; i++) {
            a[i] = -1;
        }
        a[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && a[i - coins[j]] != -1) {
                    if (a[i] == -1 || a[i] > a[i - coins[j]] + 1) {
                        a[i] = a[i - coins[j]] + 1;
                    }
                }

            }
        }
        return a[n];
    }

    // Initialization
//    void ini() {
//        // Initialization
//        actionMappings.put("IMG", (IMG) -> {
//            return new Image("IMG");
//        });
////        actionMappings.put(value2, (someParams) -> { doAction2(someParams)});
////        actionMappings.put(value3, (someParams) -> { doAction3(someParams)});
//
//    }

    void use() {
        actionMappings.get("IMG").apply("IMG");
    }


}
