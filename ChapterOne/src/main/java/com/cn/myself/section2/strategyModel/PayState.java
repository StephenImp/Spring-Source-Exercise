package com.cn.myself.section2.strategyModel;

/**
 * 创建支付状态的包装类
 */
public class PayState {

    private int code;//支付状态
    private Object data;//交易详情
    private String msg;

    public PayState(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
