package com.cn.myself.section2.adapterModel.caseBus2;

import com.cn.myself.section2.adapterModel.caseBus.*;

public class PassportForThirdAdapter extends OldLoginService implements IPassportForThird {
    @Override
    public ResultMsg loginForQQ(String id) {
        return processLogin(id, LoginFromQQAdapter.class);
    }

    @Override
    public ResultMsg loginForWechat(String id) {
        return processLogin(id, LoginFromWeChatAdapter.class);
    }

    private ResultMsg processLogin(String key, Class<? extends LoginAdapter> clazz) {
        try {

            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)){
                return adapter.login(key,adapter);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
