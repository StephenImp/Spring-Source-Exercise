package com.cn.myself.section2.appointModel.caseDemo;

public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("EmployeeA  doing ..."+command);
    }
}
