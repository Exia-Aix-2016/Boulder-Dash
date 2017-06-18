package com.github.ExiaAixA1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Data Access Object Class
 * Use singleTon pattern
 * @version 1.0
 * */
public class Dao {
    /**
     * connection url
     * */
    private final static String url = "jdbc:mysql://localhost:32770/boulderdash?autoReconnect=true&useSSL=false";
    /**
     * username
     * */
    private final static String user = "root";
    /**
     * password
     * */
    private final static String passwd = "admin";
    /**
     * Connection attribut
     * */
    private static Connection connection = null;
    private static Dao dao = null;


    /**
     * Dao.Dao Constructor. He create Connection
     * */
    private Dao(){
        try {
            connection = DriverManager.getConnection(url, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Allow to access DAO instance to take connection.
     * @return Dao instance
     * */
    public static Dao getInstance(){
        if(dao == null){
            synchronized(Dao.class){
                if(dao == null)
                    dao = new Dao();
            }
        }
        return dao;
    }

    /**
     * Allow to access instance Instance
     * @return Connection instance
     * */
    public Connection getConnection(){
        return connection;
    }
}
