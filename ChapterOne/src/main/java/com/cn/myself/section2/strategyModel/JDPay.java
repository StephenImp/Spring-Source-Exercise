package com.cn.myself.section2.strategyModel;

public class JDPay extends Payment {
    @Override
    public String getName() {
        return "京东白条";
    }

    @Override
    protected double queryBalance(String uid) {
        return 300;
    }
}
