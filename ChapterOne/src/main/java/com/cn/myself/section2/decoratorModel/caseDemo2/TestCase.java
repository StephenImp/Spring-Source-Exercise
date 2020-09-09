package com.cn.myself.section2.decoratorModel.caseDemo2;

/**
 * 为了加深印象，我们再来看一个应用场景。
 * 在讲适配器模式时，为实现新功能与老功能的兼容，创建了一个新的类继承已有的类，
 * 实现功能的扩展，遵循开闭原则。
 * 现在我们再用装饰者模式来升级一次代码，同时也做一个对比
 *
 *
 * 装饰者模式最本质的特征是将原有类的附加功能抽离出来，简化原有类的逻辑。
 * 通过案例可以总结出，其实抽象的装饰者是可有可无的，具体可以根据业务模型来选择。
 */
public class TestCase {

    public static void main(String[] args) {

        ISignInForThirdService signInForThirdService = new SignInForThirdService(new SignInService());
        signInForThirdService.loginForQQ("test");

        //动态增加或者覆盖原有方法时，采用装饰者模式
    }
}
