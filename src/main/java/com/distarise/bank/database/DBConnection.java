package com.distarise.bank.database;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    public static Logger logger = Logger.getLogger(DBConnection.class.getName());
    public Connection getConnection(String url, String username, String password, String driver){
        logger.info("Start -> DBConnection.getConnection");
        Connection connection = null;
        try {
            Class.forName(driver);
            Properties props = new Properties();
            props.setProperty("user",username);
            props.setProperty("password",password);
            //props.setProperty("ssl","true");
            connection = DriverManager.getConnection(url, props);
        }catch (Exception e){
            logger.error(e);
        }
        logger.info("End -> DBConnection.getConnection");
        return connection;
    }

}
