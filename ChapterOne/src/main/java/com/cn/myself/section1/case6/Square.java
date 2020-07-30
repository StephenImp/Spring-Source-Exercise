package com.cn.myself.section1.case6;

public class Square extends Rectangle {

    private long length;


    public static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() >= rectangle.getHeight()) {
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("width:" + rectangle.getWidth() + ",height:" + rectangle.getHeight());
        }

        System.out.println("resize() 方法结束,width:" + rectangle.getWidth() + ",height:" + rectangle.getHeight());
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public long getHeight() {
//        return super.getHeight();
        return getHeight();
    }

    public void setHeight(long height) {
//        super.setHeight(height);
        setHeight(height);
    }

    public long getWidth() {
//        return super.getWidth();
        return getWidth();
    }

    public void setWidth(long width) {
        //super.setWidth(width);
        setWidth(width);
    }

    /**
     * 里氏替换原则
     * @param args
     */
    public static void main(String[] args) {

        //demo1
//        Rectangle rectangle = new Rectangle();
//        rectangle.setWidth(20);
//        rectangle.setHeight(10);
//
//        resize(rectangle);


        //demo2
        /**
         * 代码运行时出现了死循环，违背了里氏替换原则，将父类替换为子类后，程序运行结果没有达到预期。
         * 因此，我们的代码设计是存在一定风险的。里氏替换原则只存在于父类与子类之间，约束继承泛滥
         */
        Square square = new Square();
        square.setLength(10);
        resize(square);

    }

}
