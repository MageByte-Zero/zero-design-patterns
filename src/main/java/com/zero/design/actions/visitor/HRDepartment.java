package com.zero.design.actions.visitor;

/**
 * 具体访问者：公司人力资源。
 * 职责就是负责统计核算员工每月上班时长
 * Created by ljq97 on 2017/9/5.
 */
public class HRDepartment extends AbstractDepartment {
    /**
     * 访问公司管理层对象的每月实际上班时长
     *
     * @param managerEmployee
     */
    @Override
    public void visit(ManagerEmployee managerEmployee) {
        int totalTimeSheet = managerEmployee.getTotalTimeSheet();
        StringBuilder sb = new StringBuilder("管理者:");
        sb.append(managerEmployee.getName()).append("实际上班时间").append(totalTimeSheet).append("小时");
        System.out.println(sb.toString());
    }

    /**
     * 访问普通员工的每月实际上班时长
     *
     * @param generalEmployee
     */
    @Override
    public void visit(GeneralEmployee generalEmployee) {
        int totalTimeSheet = generalEmployee.getTotalTimeSheet();
        StringBuilder sb = new StringBuilder("普通员工:");
        sb.append(generalEmployee.getName()).append("实际上班时间：").append(totalTimeSheet).append("小时");
        System.out.println(sb.toString());
    }
}
