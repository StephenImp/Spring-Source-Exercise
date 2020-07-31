package com.cn.myself.section2.proxyModel.CGLibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CGLibMeipo implements MethodInterceptor {


    public Object getInstance(Class<?> clazz) throws Exception {

        Enhancer enhancer = new Enhancer();
        //要把哪个设置成即将生成的新类的父类
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object obj = methodProxy.invokeSuper(o, objects);
        after();
        return obj;
    }

    private void after() {
        System.out.println("after()");
    }

    private void before() {
        System.out.println("before()");
    }


}
