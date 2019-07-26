package com.zero.design.actions.visitor;

/**
 * 具体访问者对象：公司财务部.
 * 职责就是负责统计员工的工资
 * Created by ljq97 on 2017/9/5.
 */
public class FaDepartment extends AbstractDepartment {
    /**
     * 访问公司管理者对象的每月工资
     *
     * @param managerEmployee
     */
    @Override
    public void visit(ManagerEmployee managerEmployee) {
        double totalWage = managerEmployee.getTotalWage();
        StringBuilder sb = new StringBuilder("管理者:");
        sb.append(managerEmployee.getName()).append(", 固定工资=").append(managerEmployee.getWage())
                .append(" ,迟到时长=").append(managerEmployee.getPunishmentTime())
                .append("小时").append(", 实发工资=").append(totalWage);
        System.out.println(sb.toString());
    }

    /**
     * 访问公司普通员工的每月工资
     *
     * @param generalEmployee
     */
    @Override
    public void visit(GeneralEmployee generalEmployee) {
        double totalWage = generalEmployee.getTotalWage();
        StringBuilder sb = new StringBuilder("普通员工:");
        sb.append(generalEmployee.getName()).append(", 固定工资=").append(generalEmployee.getWage())
                .append(" ,迟到时长=").append(generalEmployee.getPunishmentTime())
                .append("小时").append(", 实发工资=").append(totalWage);
        System.out.println(sb.toString());
    }
}
