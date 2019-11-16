package com.zero.design.actions.strategy.shopping;

/**
 * 环境(Context)角色:持有一个Strategy的引用。
 * Created by unique on 2017/6/1.
 */
public class PriceContext {
    /**
     * 持有一个具体的策略对象
     */
    private MemberStrategy memberStrategy;

    /**
     * 构造方法，传入一个具体策略
     * @param memberStrategy
     */
    public PriceContext(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    /**
     * 计算图书的价格
     * @param booksPrice
     * @return
     */
    public double calcPrice(double booksPrice) {
        return memberStrategy.calcPrice(booksPrice);
    }

    public void setMemberStrategy(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }
}
