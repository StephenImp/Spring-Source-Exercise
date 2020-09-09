package com.cn.myself.section2.decoratorModel.caseDemo2;

import com.cn.myself.section2.adapterModel.caseBus.ResultMsg;

public interface ISignInService {

    ResultMsg login(String username,String password);

    ResultMsg regist(String username,String password);
}
