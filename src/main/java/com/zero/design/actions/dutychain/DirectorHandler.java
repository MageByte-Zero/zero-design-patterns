package com.zero.design.actions.dutychain;

/**
 * 主任处理器，继承抽象处理器接口,处理相应业务或设置下一个处理器
 * Created by ljq97 on 2017/8/9.
 */
public class DirectorHandler extends AbstractLeaderHandler {


    public DirectorHandler(String handlerName) {
        super(handlerName);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        int days = request.getLeaveDays(); //获取请假天数
        String name = request.getName(); //获取请假人姓名
        String reason = request.getReason(); // 获取请假理由

        if (days <= 3) {
            //如果满足3天内的要求，主任直接审批
            System.out.println("员工" + name + "请假" + days + "天，理由：" + reason);
            System.out.println("主任" + this.handlerName + "审批通过");
        } else {
            System.out.println("请假天数过多，主任" + this.handlerName + "处理结束，还要交给经理处理");
            if(this.nextLeaderHandler != null) {
                //否则，如果链上存在下一个Leader，就让他处理
                this.nextLeaderHandler.handleRequest(request);
            }
        }
    }
}
