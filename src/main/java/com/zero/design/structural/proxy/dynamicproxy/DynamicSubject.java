package com.zero.design.structural.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，它是在运行时生成的class。在生成它时你必须提供一组interface给它，然后
 * 该class就宣称自己实现了了这些interface。
 * 你当然可以把该class的实例当作这些interface中的任何一个来用。 当然啦，这个Dynamic
 * Proxy其实就是一个Proxy，它不会替你作实质性的工作， 在生成它的实例时你必须提供一个handler，由它接管实际的工作。
 * <p>
 * 通过这种方式，被代理的对象(RealSubject)可以在运行时动态改变，需要控制的接口(Subject接口)可以在运行时改变，控
 * 制的方式(DynamicSubject类)也可以动态改变，从而实现了非常灵活的动态代理关系
 * <p>
 * Created by unique on 2017/5/14.
 */
public class DynamicSubject implements InvocationHandler {

    private Object realSubject;// 真实对象的引用

    public DynamicSubject(Object realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        preRequest(method);
        //猜测是内部根据真实对象引用并实例化，然后调用真实方法
        method.invoke(realSubject, args);
        postRequest(method);
        return null;
    }

    /**
     * 获取动态代理对象
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                this);
    }

    /**
     * 真实角色操作前的附加操作
     */
    private void postRequest(Method method) {
        System.out.println("after calling " + method);

    }

    /**
     * 真实角色操作后的附加操作
     */
    private void preRequest(Method method) {
        System.out.println("before calling " + method);

    }
}
