package com.cn.myself.section1.case1;

/**
 * 开闭原则
 */
public class Imp {

    public static void main(String[] args) {

        JavaDiscountCourse javaDiscountCourse = new JavaDiscountCourse(2,"discount",500d);
        javaDiscountCourse.getPrice();
        javaDiscountCourse.getOriginPrice();
    }
}
