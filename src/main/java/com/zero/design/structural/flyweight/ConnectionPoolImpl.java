package com.zero.design.structural.flyweight;

import com.zero.common.config.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ConcreteFlyweight:具体享元角色,享元角色的具体实现,
 * 相当于一个具体连接池对象所有细节
 * Created by unique on 2017/5/24.
 */
public class ConnectionPoolImpl implements IConnectionPoolFlyweight {

    /**
     * 连接池配置属性
     */
    private DBConfig dbConfig;

    /**
     * 连接池状态
     */
    private boolean isActive = false;

    /**
     * 记录总的创建的连接数
     */
    private AtomicInteger contActive = new AtomicInteger(0);

    /**
     * 空闲连接
     */
    private List<Connection> freeConnection = new Vector<Connection>();

    /**
     * 活动链接
     */
    private List<Connection> activeConnection = new Vector<Connection>();

    /**
     * 将线程和连接绑定，保证事务能统一执行
     */
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    public ConnectionPoolImpl(DBConfig dbConfig) {
        super();
        this.dbConfig = dbConfig;
        init();
        checkPool();
    }

    /**
     * 初始化
     */
    public void init() {
        try {
            Class.forName(dbConfig.getDriverName());
            for (int i = 0; i < dbConfig.getMinConnections(); i++) {
                //创建连接
                Connection conn = createNewConnection();
                //初始化最小连接数
                if (conn != null) {
                    threadLocal.set(conn);
                }
            }
            isActive = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return
     */
    @Override
    public synchronized Connection getConnection() {
        Connection conn = null;
        try {
            //判断是否超过最大连接数
            if (contActive.intValue() < this.dbConfig.getMaxConnections()) {
                //是否有空闲连接
                if (freeConnection.size() > 0) {
                    conn = freeConnection.get(0);
                    if (conn != null) {
                        threadLocal.set(conn);
                    }
                    freeConnection.remove(0);
                } else {
                    conn = createNewConnection();
                }

            } else {
                //超过最大连接数，继续获得连接,直到从新获得连接
                wait(this.dbConfig.getGetConnTimeOut());
                conn = getConnection();
            }

            if (isValid(conn)) {
                activeConnection.add(conn);
                contActive.addAndGet(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 获取当前线程连接
     * @return
     */
    @Override
    public Connection getCurrentConnection() {
        //默认从线程里取
        Connection connection = threadLocal.get();
        //若连接不可用，打开新连接
        if (!isValid(connection)) {
            connection = getConnection();
        }
        return connection;
    }

    /**
     * 释放连接,放入空闲连接
     * @throws SQLException
     */
    @Override
    public synchronized void releaseConn(Connection conn) throws SQLException {
        if (isValid(conn) && !(freeConnection.size() > dbConfig.getMaxConnections())) {
            freeConnection.add(conn);
            activeConnection.remove(conn);
            contActive.decrementAndGet();
            threadLocal.remove();
            //唤醒所有正在等待的线程，取抢连接
            notifyAll();;
        }
    }

    /**
     * 销毁连接池
     */
    @Override
    public synchronized void destroy() {
        closeConn(freeConnection);
        closeConn(activeConnection);
        isActive = false;
        contActive.set(0);
    }

    /**
     * 连接池状态
     * @return
     */
    @Override
    public boolean isActive() {
        return isActive;
    }

    /**
     * 定时检查连接池情况
     */
    @Override
    public void checkPool() {
        if (dbConfig.isCheckPool()) {
            /**
             * delay： 延迟执行的毫秒数，即在delay毫秒之后第一次执行
             *
             * period：重复执行的时间间隔
             */
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    // 1.对线程里面的连接状态
                    // 2.连接池最小 最大连接数
                    // 3.其他状态进行检查，因为这里还需要写几个线程管理的类，暂时就不添加了
                    System.out.println("空线池连接数："+ freeConnection.size());
                    System.out.println("活动连接数：："+ activeConnection.size());
                    System.out.println("总的连接数："+ contActive);
                }
            }, dbConfig.getLazyCheck(), dbConfig.getPeriodCheck());
        }
    }

    /**
     * 根据数据库账号密码，创建新连接
     *
     * @return
     */
    private Connection createNewConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        if (dbConfig != null) {
            Class.forName(dbConfig.getDriverName());
            synchronized (this) {
                conn = DriverManager.getConnection(dbConfig.getUrl(), dbConfig.getUserName(), dbConfig.getPassword());
            }
        }
        return conn;
    }

    /**
     * 关闭连接
     * @param connections
     */
    private void closeConn(List<Connection> connections) {
        for (Connection conn : connections) {
            if (isValid(conn)) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 判断连接是否可用
     *
     * @param conn
     * @return
     */
    private boolean isValid(Connection conn) {
        try {
            if (conn == null || conn.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


    public DBConfig getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public AtomicInteger getContActive() {
        return contActive;
    }

    public void setContActive(AtomicInteger contActive) {
        this.contActive = contActive;
    }

    public List<Connection> getFreeConnection() {
        return freeConnection;
    }

    public void setFreeConnection(List<Connection> freeConnection) {
        this.freeConnection = freeConnection;
    }

    public List<Connection> getActiveConnection() {
        return activeConnection;
    }

    public void setActiveConnection(List<Connection> activeConnection) {
        this.activeConnection = activeConnection;
    }


}
