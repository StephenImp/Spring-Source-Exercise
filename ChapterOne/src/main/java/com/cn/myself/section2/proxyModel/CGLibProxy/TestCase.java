package com.cn.myself.section2.proxyModel.CGLibProxy;

public class TestCase {

    public static void main(String[] args) {
        try {
            Customer customer = (Customer) new CGLibMeipo().getInstance(Customer.class);
            customer.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
