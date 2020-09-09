package com.cn.myself.section2.observerModel.caseDemo;

import java.util.Observable;

public class GPer extends Observable {

    private String name  = "GPer生态圈";
    private static GPer gper = null;

    public GPer() {
    }

    public GPer(String name) {
        this.name = name;
    }

    public static GPer getInstance() {
        if (null== gper){
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  void publishQuestion(Question question) {
        System.out.println(question.getUserName()+"在"+this.name+"上提交了一个问题");
        setChanged();
        notifyObservers(question);
    }
}
