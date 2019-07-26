package com.zero.design.actions.strategy.shopping;

/**
 * 具体策略(ConcreteStrategy)角色
 * 初级会员折扣具体策略
 * Created by unique on 2017/5/31.
 */
public class PrimaryMemberStrategy implements MemberStrategy {

    @Override
    public double calcPrice(double booksPrice) {
        System.out.println("对初级会员没有打折");
        return booksPrice;
    }
}
