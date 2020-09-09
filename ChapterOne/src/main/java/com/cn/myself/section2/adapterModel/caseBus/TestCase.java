package com.cn.myself.section2.adapterModel.caseBus;

public class TestCase {

    public static void main(String[] args) {
        NewLoginService newLoginService = new NewLoginService();

        //不改变原来的代码，也能够兼容新的需求，还阔以再加一层策略模式
        newLoginService.loginFromQQ("test");
    }
}
