package com.zero.design.actions.states.simple;

/**
 * 环境角色
 * Created by ljq97 on 2017/8/20.
 */
public class Context {

    /**
     * 持有State类型的对象实例
     */
    private IState state;

    public void setState(IState state) {
        this.state = state;
    }

    /**
     * 用户感兴趣的接口方法
     * @param parameter
     */
    public void request(String parameter) {
        //转调state来处理
        state.handler(parameter);
    }
}
