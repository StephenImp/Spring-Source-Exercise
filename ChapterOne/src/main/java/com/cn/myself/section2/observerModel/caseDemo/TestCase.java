package com.cn.myself.section2.observerModel.caseDemo;

public class TestCase {

    public static void main(String[] args) {
        GPer gPer = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("mic");

        gPer.addObserver(tom);
        gPer.addObserver(mic);


        //业务逻辑代码
        Question question = new Question();
        question.setUserName("imp");
        question.setContent("观察者模式适用于哪些场景？");

        gPer.publishQuestion(question);
    }


}
