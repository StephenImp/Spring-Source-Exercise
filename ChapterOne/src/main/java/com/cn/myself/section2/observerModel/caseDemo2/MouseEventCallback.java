package com.cn.myself.section2.observerModel.caseDemo2;

public class MouseEventCallback {

    public void onClick(Event e){
        System.out.println("触发鼠标打击事件"+e);
    }

    public void up(Event e){
        System.out.println("触发鼠标弹起事件"+e);
    }

    public void down(Event e){
        System.out.println("触发鼠标按下事件"+e);
    }
}
