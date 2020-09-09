package com.cn.myself.section2.templateModel.caseJDBC;

import java.sql.ResultSet;

/**
 * ①
 * 先创建约束ORM逻辑的接口RowMapper
 * @param <T>
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs,int rowNum) throws Exception;
}
