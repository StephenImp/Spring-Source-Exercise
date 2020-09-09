package com.cn.myself.section2.templateModel.caseJDBC;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class MemberDao extends JDBCTemplate{
    public MemberDao(DataSource dataSource) {
        super(dataSource);
    }


    public List<?> selectAll(){
        String sql = "select * from table";
        return super.executeQuery(sql, new RowMapper<Member>() {
            @Override
            public Member mapRow(ResultSet rs, int rowNum) throws Exception {

                Member member = new Member();
                member.setUserName("imp");
                member.setNickName("imp");

                return member;
            }
        },null);
    }

}
