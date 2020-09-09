package com.cn.myself.section2.decoratorModel.caseDemo;

public class EggDecorator extends BatterCakeDecorator {

    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomeThing() {

    }

    @Override
    public String getMsg(){
        return super.getMsg()+"鸡蛋";
    }

    @Override
    public int getPrices() {
        return super.getPrices()+2;
    }
}
