package com.zero.design.actions.states.simple;

/**
 * 具体状态类
 * Created by ljq97 on 2017/8/20.
 */
public class ConcreteStateB implements IState {
    
    /**
     * 具体状态类处理逻辑
     * @param parameter
     */
    @Override
    public void handler(String parameter) {
        System.out.println(getClass().getName().concat("handler:").concat(parameter));
    }
}
