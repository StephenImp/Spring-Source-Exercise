package com.cn.myself.section2.adapterModel.caseBus2;

import com.cn.myself.section2.adapterModel.caseBus.ResultMsg;

public class LoginFromWeChatAdapter implements LoginAdapter {

    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginFromWeChatAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
