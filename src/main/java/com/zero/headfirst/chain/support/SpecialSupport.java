package com.zero.headfirst.chain.support;

/**
 * 指定数字特殊处理
 */
public class SpecialSupport extends AbstractSupport {
   private Integer number;

    public SpecialSupport(String name, Integer number) {
        super(name);
        this.number = number;
    }

    @Override
    protected boolean resolve(NumberData numberData) {
        return numberData.getNumber().equals(number);
    }
}
