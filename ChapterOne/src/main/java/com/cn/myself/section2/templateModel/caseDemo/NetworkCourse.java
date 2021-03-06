package com.cn.myself.section2.templateModel.caseDemo;

public abstract class NetworkCourse {

    protected final void createCourse(){

        //发布预习资料
        this.postPreResource();

        //制作课件PPT
        this.createPPT();

        //在线直播
        this.liveVideo();

        //提交课堂笔记
        this.postNote();

        //提交源码
        this.postSource();

        //布置作业，有些课是有作业的，有些课是没有作业的
        //如果有作业，检查作业，如果没有作业，流程结束
        if (needHomeWork()){
            checkHomeWork();
        }
    }

    abstract void checkHomeWork();

    //钩子方法:实现流程的微调
    protected boolean needHomeWork() {
        return false;
    }

    final void postSource(){
        System.out.println("提交源码");
    }

    final void postNote(){
        System.out.println("提交课件和笔记");
    }

    final void liveVideo(){
        System.out.println("在线授课");
    }

    final void createPPT(){
        System.out.println("创建备课PPT");
    }

    final void postPreResource(){
        System.out.println("分发预学习资料");
    }

}
