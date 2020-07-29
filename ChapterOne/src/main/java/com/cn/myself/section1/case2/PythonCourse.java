package com.cn.myself.section1.case2;

public class PythonCourse implements ICourse {

    private Integer id;
    private String name;
    private Double price;

    public PythonCourse(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public void study() {
        System.out.println("python 学习");
    }
}
