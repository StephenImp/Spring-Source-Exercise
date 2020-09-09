package com.cn.myself.section2.adapterModel.caseBus2;

import com.cn.myself.section2.adapterModel.caseBus.ResultMsg;

public class LoginFromQQAdapter  implements LoginAdapter {


    @Override
    public boolean support(Object adapter) {
        return adapter instanceof  LoginFromQQAdapter;
    }

    @Override
    public ResultMsg login(String id, Object adapter) {
        return null;
    }
}
