package com.cn.myself.section2.templateModel.caseJDBC;

import java.util.List;

public class MemberDaoTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> resultList = memberDao.selectAll();
        System.out.println(resultList);
    }
}
