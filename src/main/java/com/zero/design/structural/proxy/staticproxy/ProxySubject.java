package com.zero.design.structural.proxy.staticproxy;

/**
 * 代理角色，继承角色抽象类
 * 静态代理，对真实角色对象的直接引用.
 * 这个是静态代理。真实角色必须是事先已经存在的，并将其作为代理对象的内部属性。
 * 但是实际使用时，一个真实角色必须对应一个代理角色，如果大量使用会导致类的急剧
 * 膨胀；此外，如果事先并不知道真实角色，该如何使用代理呢？这个问题可以通过Java
 * 的动态代理类来解决。
 * Created by unique on 2017/5/14.
 */
public class ProxySubject extends AbstractSubject {

    private RealSubjbect realSubjbect = null;

    /**
     * 除了代理真实角色做该做的事，代理角色提供附加操作
     * 如
     */
    @Override
    public void request() {
        preRequest(); //真实角色操作前的附加操作

        if (realSubjbect == null) {
            realSubjbect = new RealSubjbect();
        }
        realSubjbect.request();

        postRequest();//真实角色操作后的附加操作
    }
    /**
     *	真实角色操作前的附加操作
     */
    private void postRequest() {
        System.out.println("真实角色操作后的附加操作");

    }

    /**
     *	真实角色操作后的附加操作
     */
    private void preRequest() {
        System.out.println("真实角色操作前的附加操作");

    }
}
