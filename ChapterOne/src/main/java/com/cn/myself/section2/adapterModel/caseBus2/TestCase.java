package com.cn.myself.section2.adapterModel.caseBus2;

public class TestCase {

    public static void main(String[] args) {
        IPassportForThird passportForThird =   new PassportForThirdAdapter();
        passportForThird.loginForQQ("");
    }
}
