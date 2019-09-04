package com.zero.headfirst.chain.support;

import java.util.Objects;

/**
 * 抽象处理器：定义了抽象请求处理方法，持有一个抽象处理器的引用，用于生成一条处理链
 */
public abstract class AbstractSupport {
    private String name;
    private AbstractSupport next;

    /**
     * 定义处理请求的算法模板
     */
    public final void process(NumberData numberData) {
        if (resolve(numberData)) {
            done(numberData);
        } else if (Objects.nonNull(next)) {
            next.process(numberData);
        } else {
            fail(numberData);
        }
    }

    /**
     * 无法处理
     * @param numberData
     */
    protected  void fail(NumberData numberData) {
        System.out.println(numberData + " cannot be resolved.");
    }

    /**
     * 成功处理
     * @param numberData
     */
    protected void done(NumberData numberData) {
        System.out.println(numberData + " is resolved by " + this + ".");
    }

    /**
     * 判断是否能处理，子类重写
     * @param numberData
     * @return
     */
    protected abstract boolean resolve(NumberData numberData);

    public AbstractSupport setNext(AbstractSupport next) {
        this.next = next;
        return next;
    }

    public AbstractSupport(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractSupport{" +
                "name='" + name + '\'' +
                '}';
    }
}
