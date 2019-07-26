package com.zero.design.structural.proxy.dynamicproxy;

/**
 * 步骤：1. 实例化真实对象。
 * 2. 通过动态代理类构造方法生成InvocationHandler对象
 * 3. 获取真实角色类
 * 4. 通过Proxy.newProxyInstance(realSubjectClass.getClassLoader(), realSubjectClass.getInterfaces(), handler);生成动态代理
 * Created by unique on 2017/5/14.
 */
public class Test {

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
//        //实例化handler
//        InvocationHandler handler = new DynamicSubject(realSubject);
//        //获取真实角色类
//        Class realSubjectClass = realSubject.getClass();
//
//        //以下是一次性生成代理对象:
//        /**
//         * newProxyInstance()参数
//         * ClassLoader loader, 真实角色类加载
//         * @NotNull Class<?>[] interfaces, 被代理接口
//         * @NotNull reflect.InvocationHandler h 根据真实角色通过动态代理DynamicSubject实例化的handler
//         */
//        Subject subject = (Subject) Proxy.newProxyInstance(realSubjectClass.getClassLoader(), realSubjectClass.getInterfaces(), handler);
//        subject.request();

        DynamicSubject dynamicSubject = new DynamicSubject(realSubject);
        Subject proxy = dynamicSubject.getProxy();
        proxy.request();


        /**
         * 以下是分解动作
         */
        //获取动态代理类
//		Class c = Proxy.getProxyClass(realSubjectClass.getClassLoader(), realSubjectClass.getInterfaces());
//        try {
//            //获取构造方法
//            Constructor ct = c.getConstructor(new Class[]{InvocationHandler.class});
//            //根据构造方法实例化动态代理对象
//            Subject subject2 =(Subject) ct.newInstance(new Object[]{handler});
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }

    }
}
