package com.cn.myself.section2.templateModel.caseJDBC;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ②
 * 再创建封装了所有处理流程的抽象类JdbcTemplate：
 */
public abstract class JDBCTemplate {

    private DataSource dataSource;

    public JDBCTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql,RowMapper<?> rowMapper,Object[] values) {
        try {
            Connection conn = this.getConnection();
            //创建语句集
            PreparedStatement pstm = this.createPreparedStatement(conn,sql);
            //执行语句集
            ResultSet rs = this.executeQuery(pstm,values);
            //处理结果集
            List<?> result = this.paresResultSet(rs,rowMapper);

            //各种关闭...
            return result;

        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected  List<?> paresResultSet(ResultSet rs, RowMapper<?> rowMapper) throws Exception{
        List<Object> result = new ArrayList<>();
        int rowNum = 1;
        while (rs.next()) {
            result.add(rowMapper.mapRow(rs,rowNum++));
        }
        return result;
    }

    protected  ResultSet executeQuery(PreparedStatement pstm, Object[] values) throws Exception{

        for (int i = 0; i < values.length; i++) {
            pstm.setObject(i,values[i]);
        }

        return  pstm.executeQuery();

    }


    protected  PreparedStatement createPreparedStatement(Connection conn, String sql) throws Exception{
        return conn.prepareStatement(sql);

    }

    public Connection getConnection() throws Exception{
        return this.dataSource.getConnection();
    }

}
