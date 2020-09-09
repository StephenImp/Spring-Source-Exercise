package com.cn.myself.section2.decoratorModel.caseDemo;

public class BatterCakeTest {
    public static void main(String[] args) {

        BaseBatterCake baseBatterCake;

        //路边摊买一个煎饼
        baseBatterCake = new BaseBatterCake();

        //加一个鸡蛋
        baseBatterCake = new EggDecorator(baseBatterCake);

        //再加一个鸡蛋
        baseBatterCake = new EggDecorator(baseBatterCake);

        //加一根香肠
        baseBatterCake = new SausageDecorator(baseBatterCake);


        //跟静态代理最大的区别就是职责不同
        //静态代理不一定满足is-a的关系
        //静态代理会做功能的增强，是同一个职责变得不一样

        //装饰者考虑的是更多的拓展
        System.out.println(baseBatterCake.getMsg()+",总价:"+baseBatterCake.getPrices());

    }
}
