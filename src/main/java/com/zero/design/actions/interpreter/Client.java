package com.zero.design.actions.interpreter;

public class Client {

    public static void main(String[] args) {
        Context ctx = new Context();
        //初始化变量，也就是终结表达
        VariableTerminal x = new VariableTerminal("x");
        VariableTerminal y = new VariableTerminal("y");
        ConstantTerminal c = new ConstantTerminal(true);
        ctx.assign(x, false);
        ctx.assign(y, true);

        Expression exp = new Or(new And(c, x), new And(y, new Not(x)));
        System.out.println("x=" + x.interpret(ctx));
        System.out.println("y=" + y.interpret(ctx));
        System.out.println(exp.toString() + "=" + exp.interpret(ctx));
    }

}