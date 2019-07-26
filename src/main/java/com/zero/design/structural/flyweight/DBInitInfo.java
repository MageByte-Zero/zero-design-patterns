package com.zero.design.structural.flyweight;

import com.zero.common.config.DBConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据库配置初始化信息
 * Created by unique on 2017/5/18.
 */
public class DBInitInfo {
    public static List<DBConfig> dbConfigList = null;

    /**
     * 可以从xml配置文件读取
     */
    static {
        DBConfig config = new DBConfig();
        config.setDriverName("com.mysql.jdbc.Driver");
        config.setUrl("jdbc:mysql://localhost:3306/stu");
        config.setPassword("root");
        config.setUserName("root");
        config.setMaxConnections(100);
        config.setMinConnections(5);
        config.setGetConnTimeOut(6000); //6秒
        config.setCheckPool(true);
        config.setLazyCheck(10000);
        config.setPeriodCheck(6000);

        config.setPoolName("mysqlPool");
        dbConfigList = new ArrayList<DBConfig>();
        dbConfigList.add(config);
    }
}
