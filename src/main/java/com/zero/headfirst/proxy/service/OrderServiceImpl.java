package com.zero.headfirst.proxy.service;

public class OrderServiceImpl implements OrderService {
    @Override
    public String createOder(String no) {
        return "生成订单" + no + "成功";
    }
}
