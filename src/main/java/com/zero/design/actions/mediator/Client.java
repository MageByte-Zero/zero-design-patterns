package com.zero.design.actions.mediator;

/**
 * 客户端测试
 * Created by ljq97 on 2017/9/24.
 */
public class Client {
    public static void main(String[] args) {
        //实例化房屋中介
        AbstractMediator mediator = new HourseMediator();

        AbstractColleague landlordA, landlordB, renter;
        //初始化同事类中的中介示例
        landlordA = new Landlord(mediator, "房东李");
        landlordB = new Landlord(mediator, "房东张");

        renter = new Renter(mediator, "小陆");

        //房东注册中介
        mediator.registerLandlord(landlordA);
        mediator.registerLandlord(landlordB);

        //求租者注册中介
        mediator.registerRenter(renter);

        //求租者发送求租信息
        renter.sendMessage("在天河公园附近租套房子，价格1000元左右一个月");

        System.out.println("--------------------------");

        landlordA.sendMessage("天河公园学院站三巷27号四楼有一房一厅出租  1200/月  光线好 近公交站");
    }
}
