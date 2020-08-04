package com.cn.myself.section2.appointModel.caseDemo;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("EmployeeB  doing ..." + command);
    }
}
