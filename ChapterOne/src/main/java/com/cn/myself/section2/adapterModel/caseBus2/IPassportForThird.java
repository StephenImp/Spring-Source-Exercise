package com.cn.myself.section2.adapterModel.caseBus2;

import com.cn.myself.section2.adapterModel.caseBus.ResultMsg;

public interface IPassportForThird {

    ResultMsg loginForQQ(String id);

    ResultMsg loginForWechat(String id);
}
