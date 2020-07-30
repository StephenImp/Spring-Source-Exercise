package com.cn.myself.section1.case5;

import java.util.ArrayList;
import java.util.List;

public class TeamLeader {

    public void checkNumberOfCourse(){

        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            courseList.add(new Course());
        }
        System.out.println("目前已发布的课程总数:"+courseList.size());
    }
}
