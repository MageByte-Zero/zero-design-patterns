package com.zero.design.actions.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象中介者
 * Created by ljq97 on 2017/9/24.
 */
public abstract class AbstractMediator {

    /**
     * 用来存储房东角色
     */
    protected List<AbstractColleague> landlordList = new ArrayList<>();

    /**
     * 存储求租者角色
     */
    protected List<AbstractColleague> renterList = new ArrayList<>();

    /**
     * 中介注册房东信息
     * @param landlord
     */
    public void registerLandlord(AbstractColleague landlord) {
        landlordList.add(landlord);
    }

    /**
     * 中介注册求职者
     * @param landlord
     */
    public void registerRenter(AbstractColleague landlord) {
        renterList.add(landlord);
    }

    /**
     * 声明抽象方法 由具体中介者子类实现 ，消息的中转和协调
     * @param colleague
     * @param message
     */
    public abstract void operation(AbstractColleague colleague, String message);

}
