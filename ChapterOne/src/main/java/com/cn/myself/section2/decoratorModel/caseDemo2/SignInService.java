package com.cn.myself.section2.decoratorModel.caseDemo2;

import com.cn.myself.section2.adapterModel.caseBus.ResultMsg;

public class SignInService implements ISignInService {

    public ResultMsg regist(String username, String password){
        return new ResultMsg(200,"注册成功");
    }


    @Override
    public ResultMsg login(String username, String password) {
        return null;
    }
}
