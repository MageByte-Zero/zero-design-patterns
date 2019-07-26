package com.zero.design.structural.flyweight;

import com.zero.common.config.DBConfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元工厂(FlyweightFactory)角色:本角色负责创建和管理享元角色.
 * 管理所有的享元,即对连接池的所有管理,这样我们通过ConnectionPoolFactory
 * 就可以管理所连接池
 * Created by unique on 2017/5/26.
 */
public class ConnectionPoolFactory {

    /**
     * 连接池信息存放
     */
    private ConcurrentHashMap<String, IConnectionPoolFlyweight> pools = new ConcurrentHashMap<String, IConnectionPoolFlyweight>();

    //单例模式,保证只有一个享元工厂角色实例
    private ConnectionPoolFactory() {
        //初始化所有的连接池
        init();
    }

    /**
     * 单例实现
     */
    public static ConnectionPoolFactory getInstance() {
        return SingletonFactory.instance;
    }

    /**
     * 使用内部类方式，加载类的时候只初始化一次生成对象
     */
    private static class SingletonFactory {
        private static ConnectionPoolFactory instance = new ConnectionPoolFactory();
    }

    /**
     * 初始化所有连接池
     */
    private void init() {
        for (int i = 0; i < DBInitInfo.dbConfigList.size(); i++) {
            DBConfig dbConfig = DBInitInfo.dbConfigList.get(i);
            //根据构造方法初始化连接池
            ConnectionPoolImpl pool = new ConnectionPoolImpl(dbConfig);
            if (pool != null) {
                pools.put(dbConfig.getPoolName(), pool);
                System.out.println("info:init connection successed -> " + dbConfig.getPoolName());
            }
        }
    }

    /**
     * 根据poolName获取连接
     * @param poolName
     * @return
     */
    public Connection getConnection(String poolName) {
        Connection conn = null;
        if (pools.size() > 0 && pools.containsKey(poolName)) {
            conn = getPool(poolName).getConnection();
        }
        return conn;
    }

    /**
     *  根据poolName获得连接池对象
     * @param poolName
     * @return
     */
    public IConnectionPoolFlyweight getPool(String poolName) {
        IConnectionPoolFlyweight poolFlyweight = null;
        if (pools.size() > 0) {
            poolFlyweight = pools.get(poolName);
        }
        return poolFlyweight;
    }

    /**
     * 根据连接池名称，关闭、回收连接
     * @param poolName
     * @param conn
     */
    public void close(String poolName, Connection conn) {
        IConnectionPoolFlyweight pool = getPool(poolName);
        try {
            if (pool != null) {
                pool.releaseConn(conn);
            }
        } catch (SQLException e) {
            System.out.println("连接池已经销毁");
            e.printStackTrace();
        }
    }

    /**
     * 销毁连接池
     * @param poolName
     */
    public void destroy(String poolName) {
        IConnectionPoolFlyweight pool = getPool(poolName);
        if (null != pool) {
            pool.destroy();
        }
    }

}

