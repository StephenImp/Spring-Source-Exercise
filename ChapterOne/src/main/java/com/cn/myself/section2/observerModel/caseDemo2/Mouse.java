package com.cn.myself.section2.observerModel.caseDemo2;

public class Mouse extends EventLisenter {

    public void click() {
        System.out.println("调用单击方法");
        this.trigger(MouseEventType.CLICK);
    }

    public void up() {
        System.out.println("调用谈起方法");
        this.trigger(MouseEventType.UP);
    }

    public void down() {
        System.out.println("调用按下方法");
        this.trigger(MouseEventType.DOWN);
    }

}
