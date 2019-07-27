package com.zero.headfirst.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LoggerInterceptor implements InvocationHandler {

    /**
     * 持有委托类的引用
     */
    private Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println(proxy.getClass().getInterfaces()[0]);
        //通过反射调用
        System.out.println("Entered " + target.getClass().getName() + "-" + method.getName() + ",with arguments{" + args[0] + "}");
        //调用目标对象的方法
        Object result = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("执行结果：" + result.toString());
        System.out.println("共耗时：" + (end - start));
        return result;
    }

    /**
     * 获取代理类
     * @param target 真实的委托类
     * @return
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
