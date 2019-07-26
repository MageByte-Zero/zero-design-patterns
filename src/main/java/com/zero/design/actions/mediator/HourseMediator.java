package com.zero.design.actions.mediator;

/**
 * 具体中介者角色：这里的角色是 房屋中介
 * Created by ljq97 on 2017/9/24.
 */
public class HourseMediator extends AbstractMediator {
    @Override
    public void operation(AbstractColleague colleague, String message) {
        if (colleague instanceof Renter) {
            // 将租屋的需求消息传递给 中介注册了的房东们
            for (AbstractColleague landlord : landlordList) {
                landlord.getMessage(message);
            }
        } else if (colleague instanceof Landlord) {
            // 将房东的出租房消息传递给 中介注册了的 房屋求租者们
            for (AbstractColleague renter : renterList) {
                renter.getMessage(message);
            }
        }
    }
}
