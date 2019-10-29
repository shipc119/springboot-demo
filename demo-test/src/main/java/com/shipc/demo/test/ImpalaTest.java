package com.shipc.demo.test;

import java.sql.*;

/**
 * @author shipc 2019/10/24 11:34
 * @version 1.0
 */
public class ImpalaTest {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.cloudera.impala.jdbc41.Driver");
            connection = DriverManager.getConnection("jdbc:impala://localhost:21050/default", "root", "");
            if (connection == null) {
                System.out.println("failed");
            }
            System.out.println("success");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
