package com.cn.myself.section1.case3;

public class Course {

    //单一职责
    public void study(String courseName){
        if ("直播课".equals(courseName)){
            System.out.println(courseName+"不能快进");
        }else {
            System.out.println(courseName+"可以反复回看");
        }
    }
}
