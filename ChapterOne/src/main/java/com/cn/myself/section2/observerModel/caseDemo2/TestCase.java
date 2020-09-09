package com.cn.myself.section2.observerModel.caseDemo2;

public class TestCase {

    public static void main(String[] args) {
        try {
            MouseEventCallback callback = new MouseEventCallback();

            //注册事件
            Mouse mouse  = new Mouse();
            mouse.addListener(MouseEventType.UP,callback);
            mouse.addListener(MouseEventType.DOWN,callback);
            mouse.addListener(MouseEventType.CLICK,callback);

            //调用方法
            mouse.click();
            mouse.up();


        }catch (Exception e) {

        }
    }
}
