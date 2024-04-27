package com.rain.util;

import java.sql.*;

public class DBUtil
    {
        /**
         * 连接数据库的操作，用户名，密码，使用jdbc连接
         */
        public static String username = "Encounter";
        public static String password = "20020628";
        public static String url = "jdbc:mysql://localhost:3306/bms?serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

        static
            {
                try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    }
                catch (ClassNotFoundException e)
                    {
                        e.printStackTrace();
                    }
            }

        public static Connection getConnectDb()
            {
                Connection conn = null;
                try
                    {
                        conn = DriverManager.getConnection(url, username, password);
                    }
                catch (SQLException e)
                    {
                        e.printStackTrace();
                    }
                return conn;
            }

        /**
         * 测试连接
         */
        public static void main(String[] args)
            {
                System.out.println(getConnectDb());
            }
        public static void CloseDB(ResultSet rs, PreparedStatement stm, Connection conn)
            {
                if (rs != null)
                    {
                        try
                            {
                                rs.close();
                            }
                        catch (SQLException e)
                            {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                    }
                if (stm != null)
                    {
                        try
                            {
                                stm.close();
                            }
                        catch (SQLException e)
                            {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                    }
                if (conn != null)
                    {
                        try
                            {
                                conn.close();
                            }
                        catch (SQLException e)
                            {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                    }
            }


    }
