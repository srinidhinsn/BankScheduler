package com.distarise.bank.scheduler;


import com.distarise.bank.migration.Firebase;
import com.distarise.bank.model.Customer;
import com.distarise.bank.service.DbOperations;
import com.google.firebase.database.FirebaseDatabase;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Timer;


public class BankJobTrigger {
    public static Logger logger = Logger.getLogger(BankJobTrigger.class.getName());
    public static int count = 0;
    public static int intervalInMin;
    public static String firebaseServiceAccount;
    public static String dbConnectionString;
    public static String dbUsername;
    public static String password;
    public static String dbDriver;
    public static String firebaseUrl;
    public static int firebaseTimeout;
    public static int transactionHistoryCount;
    public static int batchInsertCount;
    public static void main(String[] args) {
        Timer t = new Timer();
        try{
            logger.info("Initializing properties");
            setProperties();
            setLoggerInfo();
            logger.info("Properties are set");
            BankScheduledJob bankScheduledJob = new BankScheduledJob();
            t.scheduleAtFixedRate(bankScheduledJob, 0, 1000*60*intervalInMin);
            logger.info("Exiting main program");
        }catch (IOException io){
            logger.error(io);
            io.printStackTrace();
        } catch (Exception e){
            logger.error(e);
            e.printStackTrace();
        }

    }

    private static void setProperties() throws IOException {
        FileReader reader=new FileReader("job.properties");
        Properties p=new Properties();
        p.load(reader);
        dbUsername = p.getProperty("db.username");
        password = p.getProperty("db.password");
        dbConnectionString = p.getProperty("db.connection.string");
        dbDriver = p.getProperty("db.driverclass");
        firebaseUrl = p.getProperty("mobile.firebase.url");
        firebaseServiceAccount = p.getProperty("mobile.firebase.serviceaccount");
        firebaseTimeout = Integer.parseInt(p.getProperty("mobile.firebase.timeout"));
        intervalInMin = Integer.parseInt(p.getProperty("job.run.interval.minutes"));
        transactionHistoryCount = Integer.parseInt(p.getProperty("job.transaction.history.records"));
        batchInsertCount = Integer.parseInt(p.getProperty("job.batch.insert.count"));
    }

    public static void setLoggerInfo(){
        String log4jConfigFile = "log4j.properties";
        PropertyConfigurator.configure(log4jConfigFile);
        logger.debug("this is a debug log message");
        logger.info("this is a information log message");
        logger.warn("this is a warning log message");
    }
}
