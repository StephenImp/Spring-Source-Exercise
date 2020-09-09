package com.cn.myself.section2.adapterModel.caseBus;

/**
 * 后面又加上了三方登录的逻辑
 * 稳定的方法直接继承下来
 */
public class NewLoginService extends OldLoginService {

    public ResultMsg loginFromQQ(String openId){
        return loginAndRegist(openId,null);
    }

    public ResultMsg loginFromWeChat(String openId){
        return new ResultMsg();
    }

    public ResultMsg loginAndRegist(String username,String password){

        super.regist(username,password);
        super.login(username,password);

        return new ResultMsg();
    }


}
