package com.zero.design.structural.flyweight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by unique on 2017/5/28.
 */
public class Test {

    public static void main(String[] args) {
        ConnectionPoolFactory poolFactory = ConnectionPoolFactory.getInstance();
        Connection conn = poolFactory.getConnection("mysqlPool");
        String sql = "SELECT cityID, cityName FROM city";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                System.out.println("[id:" + id + ",name:" + name + "]");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            poolFactory.close("mysqlPool", conn);
        }

    }
}
