package com.cn.myself.section2.decoratorModel.caseDemo;

public class SausageDecorator extends BatterCakeDecorator {

    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomeThing() {

    }

    @Override
    public String getMsg(){
        return super.getMsg()+"香肠";
    }

    @Override
    public int getPrices() {
        return super.getPrices()+3;
    }
}
