package com.zero.design.actions.strategy.shopping;

/**
 * 高级会员折扣策略
 * Created by unique on 2017/5/31.
 */
public class AdvanceMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        return booksPrice * 0.8;
    }
}
