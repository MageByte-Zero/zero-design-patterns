package com.zero.headfirst.chain.support;

/**
 * 永远不解决
 */
public class NoSupport extends AbstractSupport {
    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(NumberData numberData) {
        return false;
    }
}
