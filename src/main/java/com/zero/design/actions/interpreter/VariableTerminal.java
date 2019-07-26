package com.zero.design.actions.interpreter;

/**
 * 终结符表达式:一个对象代表一个有名变量。任何标识符,代表一个变量
 * Created by ljq97 on 2017/9/29.
 */
public class VariableTerminal extends Expression {

    private String name;

    public VariableTerminal(String name) {
        this.name = name;
    }

    @Override
    public boolean interpret(Context context) {
        return context.lookup(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof VariableTerminal) {
            return this.name.equals(((VariableTerminal) obj).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
