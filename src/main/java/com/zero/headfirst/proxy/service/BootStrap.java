package com.zero.headfirst.proxy.service;

import com.zero.headfirst.proxy.LoggerInterceptor;

public class BootStrap {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();
        ProductService productService = new ProductServiceImpl();

        LoggerInterceptor loggerInterceptor = new LoggerInterceptor();

        OrderService orderServiceProxy = (OrderService) loggerInterceptor.bind(orderService);
        orderServiceProxy.createOder("12927381");

        ProductService productServiceProxy = (ProductService) loggerInterceptor.bind(productService);
        productServiceProxy.getProduct("34010234");
    }
}
