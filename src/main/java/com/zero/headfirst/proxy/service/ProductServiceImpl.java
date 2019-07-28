package com.zero.headfirst.proxy.service;

public class ProductServiceImpl implements ProductService {
    @Override
    public String getProduct(String no) {
        return "获取商品" + no + "成功";
    }
}
