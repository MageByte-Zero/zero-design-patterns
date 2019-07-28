package com.zero.headfirst.proxy.jdk;

import com.zero.headfirst.proxy.service.OrderService;
import com.zero.headfirst.proxy.service.OrderServiceImpl;
import com.zero.headfirst.proxy.service.ProductService;
import com.zero.headfirst.proxy.service.ProductServiceImpl;

public class JdkProxyBootStrap {
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
