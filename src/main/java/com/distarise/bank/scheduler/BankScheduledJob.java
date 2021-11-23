package com.distarise.bank.scheduler;

import com.distarise.bank.migration.Firebase;
import com.distarise.bank.model.Customer;
import com.distarise.bank.service.DbOperations;
import com.google.firebase.database.FirebaseDatabase;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public class BankScheduledJob extends TimerTask {
    public static Logger logger = Logger.getLogger(BankScheduledJob.class.getName());
    @Override
    public void run() {
        logger.info("Start -> BankScheduledJob.run");
        try{
            DbOperations dbOperations = new DbOperations();
            dbOperations.batchInsert();
            BankJobTrigger.count=0;
        } catch (Exception e){
            logger.error(e);
        }
        logger.info("End -> BankScheduledJob.run");
    }

    public Map<String, Customer> createCustomer(){
        HashMap<String, Customer> customer1 = new HashMap<>();
        if (BankJobTrigger.count == 0) {
            customer1.put("1", new Customer());
            customer1.put("2", new Customer());
        } else if (BankJobTrigger.count == 1) {
            customer1.put("3", new Customer());
            customer1.put("4", new Customer());
        } else {
            customer1.put("5", new Customer());
            customer1.put("6", new Customer());
        }
        BankJobTrigger.count++;
        return customer1;
    }
}
