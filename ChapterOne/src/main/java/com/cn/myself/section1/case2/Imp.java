package com.cn.myself.section1.case2;

/**
 * 依赖倒置
 */
public class Imp {

    //改成依赖注入的方式
    private ICourse course;

//    public Imp(ICourse course) {
//        this.course = course;
//    }

//    public void study(ICourse course){
//        course.study();
//    }


    public void setCourse(ICourse course) {
        this.course = course;
    }

    public void study(){
        course.study();
    }

//    public void studyJavaCourse(){
//        System.out.println("Imp 正在学习 java");
//    }
//
//    public void studyPythonCourse(){
//        System.out.println("Imp 正在学习 python");
//    }


    public static void main(String[] args) {

        //最蠢 的 直接调用方法
//        Imp imp = new Imp();
//        imp.studyJavaCourse();
//        imp.studyPythonCourse();

        //简单的策略模式   这里的话，初步的解耦
//        imp.study(new JavaCourse(1,"java",50d));
//        imp.study(new PythonCourse(1,"python",50d));


        //模拟Spring 的 依赖注入 (构造器方式)  原型模式?
//        Imp imp = new Imp(new JavaCourse(1,"java",50d));
//        imp.study();


        //下面的方式，如果是imp单例的话，则提高了系统的稳定性   单例模式？

        //模拟Spring 的 依赖注入 (setter方式)
        Imp imp = new Imp();
        imp.setCourse(new JavaCourse(1,"java",50d));
        imp.study();

    }
}
