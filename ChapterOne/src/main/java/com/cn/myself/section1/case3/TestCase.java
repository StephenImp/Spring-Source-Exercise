package com.cn.myself.section1.case3;

import org.junit.Test;

//单一原则
public class TestCase {

    @Test
    public void test1(){
        Course course = new Course();
        course.study("直播课");
        course.study("录播课");
    }

    @Test
    public void test2(){
        LiveCourse liveCourse =new LiveCourse();
        liveCourse.study("直播课");

        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");
    }

}
