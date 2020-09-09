package com.cn.myself.section2.decoratorModel.badCode;

public class BatterCakeWithEgg extends BatterCake {

    @Override
    public String getMsg(){
        return super.getMsg()+"鸡蛋";
    }

    @Override
    public int getPrices() {
        return super.getPrices()+2;
    }
}
