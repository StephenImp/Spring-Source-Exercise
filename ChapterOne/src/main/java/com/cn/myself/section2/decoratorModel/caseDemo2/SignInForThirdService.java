package com.cn.myself.section2.decoratorModel.caseDemo2;

import com.cn.myself.section2.adapterModel.caseBus.ResultMsg;

public class SignInForThirdService implements ISignInForThirdService{

    private ISignInService signIn;

    public SignInForThirdService(ISignInService signIn) {
        this.signIn = signIn;
    }

    @Override
    public ResultMsg loginForQQ(String id) {
        return login(id,null);
    }

    @Override
    public ResultMsg loginForWeChat(String id) {
        return null;
    }

    @Override
    public ResultMsg login(String username, String password) {
        return signIn.login(username,password);
    }

    @Override
    public ResultMsg regist(String username, String password) {
        return signIn.regist(username,password);
    }
}
