package com.cn.myself.section2.appointModel.caseMvc;

import java.lang.reflect.Method;

public class Handler {

    private Object controller;
    private Method method;
    private String url;

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method, Class[] classes) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
