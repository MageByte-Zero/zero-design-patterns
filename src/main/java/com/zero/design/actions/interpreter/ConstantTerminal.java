package com.zero.design.actions.interpreter;

/**
 * 终结符表达式(Terminal Expression)角色:代表一个布尔常量
 * 在这里终结符是布尔变量，也就是常量true和false
 *
 * @author ljq97
 * @date 2017/9/29
 */
public class ConstantTerminal extends Expression {
    private boolean value;

    /**
     * 解释器
     * @param context
     * @return
     */
    @Override
    public boolean interpret(Context context) {
        return value;
    }

    public ConstantTerminal(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ConstantTerminal) {
            return this.value == ((ConstantTerminal) obj).value;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return new Boolean(value).toString();
    }
}
