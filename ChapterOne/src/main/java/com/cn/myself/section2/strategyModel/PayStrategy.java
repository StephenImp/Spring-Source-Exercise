package com.cn.myself.section2.strategyModel;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {

    public static final String ALI_PAY = "AliPay";
    public static final String JD_PAY = "JDPay";
    public static final String WECHAT_PAY = "WechatPay";
    public static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String,Payment> paymentMap = new HashMap<>();

    static {
        paymentMap.put(ALI_PAY,new AliPay());
        paymentMap.put(JD_PAY,new JDPay());
        paymentMap.put(WECHAT_PAY,new WechatPay());
    }

    public static Payment get(String  payKey){
        if (!paymentMap.containsKey(payKey)){
            return paymentMap.get(DEFAULT_PAY);
        }
        return paymentMap.get(payKey);
    }



}
