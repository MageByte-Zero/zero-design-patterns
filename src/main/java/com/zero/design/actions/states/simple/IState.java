package com.zero.design.actions.states.simple;

/**
 * Created by ljq97 on 2017/8/20.
 */
public interface IState {

    /**
     * 不同状态对应的处理方法
     * @param parameter
     */
    void handler(String parameter);
}
