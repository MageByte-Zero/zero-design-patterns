package com.zero.design.actions.strategy.shopping;

/**
 * 客户端调用
 * Created by unique on 2017/6/1.
 */
public class Clinet {
    public static void main(String[] args) {
        //选择并创建所要的策略
        MemberStrategy strategy = new AdvanceMemberStrategy();

        //创建环境
        PriceContext context = new PriceContext(strategy);
        double booksPrice = 500.98;
        double price = context.calcPrice(booksPrice);
        System.out.println("图书的原价:" + booksPrice + "打折后的最终价格：" + price);
    }

}
