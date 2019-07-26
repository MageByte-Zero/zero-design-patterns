package com.zero.design.actions.strategy.shopping;

/**
 * 抽象折扣类(抽象策略(Strategy)角色)
 * Created by unique on 2017/5/31.
 */
public interface MemberStrategy {

    /**
     * 计算图书的价格
     * @param booksPrice 原书价格
     * @return 打折后的价格
     */
    double calcPrice(double booksPrice);
}
