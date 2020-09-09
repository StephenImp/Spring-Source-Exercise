package com.cn.myself.section2.decoratorModel.caseDemo;

/**
 * 扩展套餐的抽象装饰者类
 */
public abstract class BatterCakeDecorator extends BaseBatterCake {

    //静态代理，委派
    private BatterCake batterCake;

    public BatterCakeDecorator(BatterCake batterCake) {
        this.batterCake = batterCake;
    }

    protected abstract void doSomeThing();


    @Override
    protected String getMsg() {
        return this.batterCake.getMsg();
    }


    @Override
    protected int getPrices(){
        return this.batterCake.getPrices();
    }

}
