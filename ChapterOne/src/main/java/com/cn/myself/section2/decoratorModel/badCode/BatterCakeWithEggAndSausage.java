package com.cn.myself.section2.decoratorModel.badCode;

public class BatterCakeWithEggAndSausage extends BatterCakeWithEgg {

    @Override
    public String getMsg(){
        return super.getMsg()+"香肠";
    }

    @Override
    public int getPrices() {
        return super.getPrices()+3;
    }
}
