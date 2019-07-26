package com.zero.design.actions.visitor;

/**
 * 抽象被访问者：公司员工抽象类
 * Created by ljq97 on 2017/8/31.
 */
public abstract class AbstractEmployee {
    /**
     * 接收一个抽象访问者对象
     * @param department 抽象访问者 这里指的是公司部门如 人力资源部、财务部
     */
    public abstract void accept(AbstractDepartment department);
}
