package com.zero.design.actions.strategy.enums;

/**
 * Created by unique on 2018/3/5.
 */
public class Client {
    public static void main(String[] args) {
        double pay = PayrollDay.MONDAY.pay(8, 100);
        System.out.println(PayrollDay.MONDAY.toString() + ":" + pay);
    }
}
