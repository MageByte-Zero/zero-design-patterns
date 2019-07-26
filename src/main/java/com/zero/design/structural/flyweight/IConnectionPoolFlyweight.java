package com.zero.design.structural.flyweight;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 抽象享元角色类：规定所有具体元角色所需要实现的方法,将连接池抽象化
 * Created by unique on 2017/5/18.
 */
public interface IConnectionPoolFlyweight {

    /**
     * 获取连接
     *
     * @return
     */
    Connection getConnection();

    /**
     * 获取当前连接
     *
     * @return
     */
    Connection getCurrentConnection();

    /**
     * 回收连接
     * @throws SQLException
     */
    void releaseConn(Connection conn) throws SQLException;

    /**
     * 销毁清空
     */
    void destroy();

    /**
     * 连接池是否活动状态
     * @return
     */
    boolean isActive();

    /**
     * 定时器，检查连接池
     */
    void checkPool();

}
