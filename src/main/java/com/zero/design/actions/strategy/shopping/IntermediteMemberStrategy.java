package com.zero.design.actions.strategy.shopping;

/**
 * 中级会员折扣策略
 * Created by unique on 2017/5/31.
 */
public class IntermediteMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对于中级会员的折扣为10%");
        return booksPrice * 0.9;
    }
}
