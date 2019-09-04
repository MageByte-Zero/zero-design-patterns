package com.zero.headfirst.chain.support;

/**
 * 解决指定区间
 */
public class LimitSupport extends AbstractSupport {

    private Integer limit;

    public LimitSupport(String name, Integer limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    protected boolean resolve(NumberData numberData) {
        return numberData.getNumber() < limit;
    }
}
