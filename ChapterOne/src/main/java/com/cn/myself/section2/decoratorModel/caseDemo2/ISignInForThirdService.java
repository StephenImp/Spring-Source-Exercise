package com.cn.myself.section2.decoratorModel.caseDemo2;

import com.cn.myself.section2.adapterModel.caseBus.ResultMsg;

public interface ISignInForThirdService  extends ISignInService{

    ResultMsg loginForQQ(String id);
    ResultMsg loginForWeChat(String id);

}
