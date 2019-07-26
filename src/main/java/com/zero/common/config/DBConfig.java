package com.zero.common.config;

/**
 * 数据库配置
 * Created by unique on 2017/5/18.
 */
public class DBConfig {

    private String poolName;

    private String driverName;

    private String url;

    private String userName;

    private String password;

    private Integer minConnections;

    private Integer maxConnections;

    /**
     * 获取连接超时时间(毫秒)
     */
    private Integer getConnTimeOut;

    /**
     * 是否定时检查连接池情况
     */
    private boolean isCheckPool;

    /**
     * 延迟执行毫秒数
     */
    private Integer lazyCheck;

    /**
     * 重复执行间隔毫秒数
     */
    private Integer periodCheck;

    public boolean isCheckPool() {
        return isCheckPool;
    }

    public Integer getLazyCheck() {
        return lazyCheck;
    }

    public void setLazyCheck(Integer lazyCheck) {
        this.lazyCheck = lazyCheck;
    }

    public Integer getPeriodCheck() {
        return periodCheck;
    }

    public void setPeriodCheck(Integer periodCheck) {
        this.periodCheck = periodCheck;
    }

    public void setCheckPool(boolean checkPool) {
        isCheckPool = checkPool;
    }

    public Integer getGetConnTimeOut() {
        return getConnTimeOut;
    }

    public void setGetConnTimeOut(Integer getConnTimeOut) {
        this.getConnTimeOut = getConnTimeOut;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMinConnections() {
        return minConnections;
    }

    public void setMinConnections(Integer minConnections) {
        this.minConnections = minConnections;
    }

    public Integer getMaxConnections() {
        return maxConnections;
    }

    public void setMaxConnections(Integer maxConnections) {
        this.maxConnections = maxConnections;
    }
}
