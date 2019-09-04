package com.zero.headfirst.chain.support;

/**
 * 奇数处理
 */
public class OddSupport extends AbstractSupport {
    public OddSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(NumberData numberData) {
        return numberData.getNumber() % 2 == 1;
    }
}
