package com.cn.myself.section2.adapterModel.caseBus2;

import com.cn.myself.section2.adapterModel.caseBus.ResultMsg;

public interface LoginAdapter {

    boolean support(Object adapter);
    ResultMsg login(String id, Object adapter);
}
