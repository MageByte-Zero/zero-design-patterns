package com.zero.design.actions.visitor;

/**
 * 具体被访问者:公司管理者
 * Created by ljq97 on 2017/8/31.
 */
public class ManagerEmployee extends AbstractEmployee {
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 每天上班时长
     */
    private int timeSheet;
    /**
     * 月薪
     */
    private double wage;
    /**
     * 请假/迟到 惩罚时长
     */
    private int punishmentTime;

    public ManagerEmployee(String name, int timeSheet, double wage, int punishmentTime) {
        this.name = name;
        this.timeSheet = timeSheet;
        this.wage = wage;
        this.punishmentTime = punishmentTime;
    }

    /**
     * 接收访问者的访问,并将visit参数则是当前自己对象.。从而达到实现不同访问逻辑
     * @param department 抽象访问者 这里指的是公司部门如 人力资源部、财务部
     */
    @Override
    public void accept(AbstractDepartment department) {
        department.visit(this);
    }

    /**
     * 获取每月上班时长 = 每天上班时长 * 每月上班天数 - 惩罚时长
     * @return
     */
    public int getTotalTimeSheet() {
        return timeSheet * 22 - punishmentTime;
    }

    /**
     * 获取每月应发工资 = 每月固定工资 - 惩罚时长 * 5
     * <p>作为公司管理者 没迟到1小时扣5元</p>
     * @return
     */
    public double getTotalWage() {
        return wage - punishmentTime * 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimeSheet() {
        return timeSheet;
    }

    public void setTimeSheet(int timeSheet) {
        this.timeSheet = timeSheet;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getPunishmentTime() {
        return punishmentTime;
    }

    public void setPunishmentTime(int punishmentTime) {
        this.punishmentTime = punishmentTime;
    }
}
