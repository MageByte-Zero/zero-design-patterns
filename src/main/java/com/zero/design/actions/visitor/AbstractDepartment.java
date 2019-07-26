package com.zero.design.actions.visitor;

/**
 * 抽象访问者：公司部门抽象类。
 * 声明一组访问方法，用于访问不同类型的具体元素(这里指的是不同类型的员工)
 * Created by ljq97 on 2017/8/31.
 */
public abstract class AbstractDepartment {

    /**
     * 访问公司管理者对象
     * @param managerEmployee
     */
    public abstract void visit(ManagerEmployee managerEmployee);

    /**
     * 访问普通员工
     * @param generalEmployee
     */
    public abstract void visit(GeneralEmployee generalEmployee);

}
