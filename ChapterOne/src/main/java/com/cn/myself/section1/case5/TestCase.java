package com.cn.myself.section1.case5;

/**
 * 迪米特原则
 *
 * 现在来设计一个权限系统， Boss需要查看目前发布到线上的课程数量。
 * 这时候， Boss要找到TeamLeader去进行统计
 * TeamLeader再把统计结果告诉Boss。
 *
 */
public class TestCase {

    public static void main(String[] args) {
        Boss boss = new Boss();
        TeamLeader teamLeader = new TeamLeader();
        boss.commandAndCheckNumber(teamLeader);
    }
}
