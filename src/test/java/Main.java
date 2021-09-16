import com.jr.bundlecalculator.entity.Order;
import com.jr.bundlecalculator.entity.OrderItems;

import java.util.*;

public class Main {

    private static void test3(int[][] a) {
        for (int i = 0; i < 3; i++) {
            System.out.println(a[0][i]);
        }
    }

    private static void test4(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("$ " + a[i] + " $");
        }
    }

    public static void main(String[] args) {
        int[][] a = { {1,2,3},{99,100,101} };
        test3(a);
        test4(a[0]);
//        priceList.stream().mapToInt(Integer::valueOf).sum() + "";
//        Order order = new Order();
//        List<OrderItems> item123 = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            OrderItems orderItems = new OrderItems();
//            orderItems.setBrandName("Bundle" + i);
//            orderItems.setAmount(i+"");
//            order.addOrderItems(orderItems);
////            order.getOrderItemsList().add(orderItems);
//        }
//        OrderItems orderItems2 = new OrderItems();
//        orderItems2.setBrandName("Item1");
//        orderItems2.setAmount("1");
//        item123.add(orderItems2);
//        orderItems2.setBrandName("Item5");
//        orderItems2.setAmount("5");
//        item123.add(orderItems2);
//        orderItems2.setBrandName("Item99");
//        orderItems2.setAmount("99");
//        item123.add(orderItems2);
//
//        System.out.println(order.toString());
//
//        boolean tr = Arrays.stream(Brand.values()).anyMatch((t) -> t.name().equals("IMG"));
//        System.out.println("1");
////        EnumUtils.isValidEnum(Day.class, "MONDAY")
////        Brand.class


    }

    private static void test1() {
        Map<String,Double> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list.add("2 * 5");
        list.add("1 * 3");
        list2.add("1147.5");
        list2.add("810");
        map.put("2 * 5",1800.0);
        map.put("1 * 3", 570.0);
        OrderItems orderItems = new OrderItems();
        orderItems.setBrandName("VID");
        orderItems.setBundle(new int[]{3,5,9});
        orderItems.setAmount("13");
        orderItems.setMinimalNumber("3");
        orderItems.setMinimalCase("5 5 3");
        orderItems.setTotalAmount("13");
        orderItems.setTotalSpend("2370");
        orderItems.setBundleList(list);
        orderItems.setPriceList(list2);
        System.out.println(orderItems.toString());

        Order order = new Order();
        order.addOrderItems(orderItems);

        System.out.println(order.toString());
    }


}
