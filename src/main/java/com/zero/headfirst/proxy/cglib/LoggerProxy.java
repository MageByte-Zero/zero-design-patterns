package com.zero.headfirst.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class LoggerProxy implements MethodInterceptor {


    /**
     * 创建代理类
     * @param targetClass 委托类
     * @return
     */
    public Object bind(Class targetClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClass);
        //设置回调方，当客户端通过代理调用方法的时候会会调用我们重写的 intercept() 方法
        enhancer.setCallback(this);
        //创建代理类
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        //通过反射调用
        System.out.println("Entered " + o.getClass().getName() + "-" + method.getName() + ",with arguments{" + args[0] + "}");
        Object result = methodProxy.invokeSuper(o, args);
        long end = System.currentTimeMillis();
        System.out.println("执行结果：" + result.toString());
        System.out.println("共耗时：" + (end - start));
        return result;
    }
}
