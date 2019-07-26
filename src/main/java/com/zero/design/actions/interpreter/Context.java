package com.zero.design.actions.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境角色：定义出从变量到布尔值的一个映射
 * Created by ljq97 on 2017/9/29.
 */
public class Context {

    private Map<VariableTerminal, Boolean> map = new HashMap<>();

    /**
     * 变量与布尔值的映射
     * @param var
     * @param value
     */
    public void assign(VariableTerminal var, boolean value) {
        map.put(var, new Boolean(value));
    }

    /**
     * 根据变量获取布尔值
     * @param var
     * @return
     */
    public boolean lookup(VariableTerminal var) {
        Boolean value = map.get(var);
        if (value == null) {
            throw new IllegalArgumentException();
        }
        return value.booleanValue();
    }
}
