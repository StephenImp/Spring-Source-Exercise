package com.cn.myself.section2.strategyModel;

public class PayStrategyTest {
    public static void main(String[] args) {

        Order order = new Order("1","20200804",200);
        order.pay(PayStrategy.JD_PAY);


//        Payment payment = new Payment() {
//            @Override
//            public String getName() {
//                return "test";
//            }
//
//            @Override
//            protected double queryBalance(String uid) {
//                return 0;
//            }
//        };
//        System.out.println(payment.getName());


    }
}
