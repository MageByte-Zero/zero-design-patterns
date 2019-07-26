package com.zero.design.actions.interpreter;

/**
 * 抽象表达式角色
 * Created by ljq97 on 2017/9/29.
 */
public abstract class Expression {

    /**
     * 以环境为主，解释给定的任何表达式.由不同子类实现
     * @param context
     * @return
     */
    public abstract boolean interpret(Context context);

    /**
     * 校验两个表达式在结构上是否相同
     * @param obj
     * @return
     */
    @Override
    public abstract boolean equals(Object obj);

    /**
     * 返回表达式的hashCode
     * @return
     */
    @Override
    public abstract int hashCode();

    /**
     * 将表达式转换为字符串
     * @return
     */
    @Override
    public abstract String toString();
}
