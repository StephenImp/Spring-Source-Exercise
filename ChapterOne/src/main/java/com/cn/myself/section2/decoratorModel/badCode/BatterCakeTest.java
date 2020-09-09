package com.cn.myself.section2.decoratorModel.badCode;

/**
 * 如果用户需要一个加2个鸡蛋、加1根香肠的煎饼，用我们现在的类结构是创建不出来的，
 * 也无法自动计算出价格，除非再创建一个类做定制。如果需求再变，一直做定制显然是不科学的
 */
public class BatterCakeTest {
    public static void main(String[] args) {
        BatterCake batterCake = new BatterCake();
        BatterCakeWithEgg batterCakeWithEgg = new BatterCakeWithEgg();
        BatterCakeWithEggAndSausage batterCakeWithEggAndSausage = new BatterCakeWithEggAndSausage();
    }
}
