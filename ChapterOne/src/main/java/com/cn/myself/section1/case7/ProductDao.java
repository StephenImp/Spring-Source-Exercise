package com.cn.myself.section1.case7;

public class ProductDao {

    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("使用"+conn+"增加产品");
    }

}
