package com.cn.myself.section2.adapterModel.caseDemo;

/**
 *
 * 适配器模式（Adapter Pattern）是指将一个类的接口转换成用户期望的另一个接口，
 * 使原本接口不兼容的类可以一起工作，属于结构型设计模式
 * 通过增加电源适配器类PowerAdapter实现了二者的兼容
 */
public class AdapterTest {
    public static void main(String[] args) {
        DC5 dc5 = new PowerAdapter(new AC220());
        dc5.outputDC5V();
    }
}
