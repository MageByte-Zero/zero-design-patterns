package com.zero.headfirst.proxy.cglib;

import com.zero.headfirst.proxy.service.OrderService;
import com.zero.headfirst.proxy.service.OrderServiceImpl;
import com.zero.headfirst.proxy.service.ProductService;
import com.zero.headfirst.proxy.service.ProductServiceImpl;

public class CglibBootStrap {
    public static void main(String[] args) {

        LoggerProxy loggerProxy = new LoggerProxy();

        OrderService orderService = (OrderService) loggerProxy.bind(OrderServiceImpl.class);
        orderService.createOder("12873051209g");


        ProductService productProxy = (ProductService) loggerProxy.bind(ProductServiceImpl.class);
        productProxy.getProduct("2780935782309");


    }
}
