package com.distarise.bank.service;

import com.distarise.bank.database.DBConnection;
import com.distarise.bank.database.QueryConstants;
import com.distarise.bank.migration.Firebase;
import com.distarise.bank.model.Customer;
import com.distarise.bank.model.RemainingAcct;
import com.distarise.bank.model.SavingBank;
import com.distarise.bank.model.Share;
import com.distarise.bank.scheduler.BankJobTrigger;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DbOperations {
    public static Logger logger = Logger.getLogger(DbOperations.class.getName());
    public void update(FirebaseDatabase firebaseDatabase, Map<String, Customer> customerDetails) throws InterruptedException {
        logger.info("Start -> DbOperations.update");
        Iterator<String> keys = customerDetails.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            firebaseDatabase.getReference(key).setValue(customerDetails.get(key), new DatabaseReference.CompletionListener() {
                @Override
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    if (databaseError != null) {
                        logger.error("Error while updating firebase - "+databaseError.getMessage());
                    } else {
                        logger.info(customerDetails.size()+" - customers saved successfully");
                    }
                }
            });
        }
        Thread.sleep(BankJobTrigger.firebaseTimeout);
        logger.info("End -> DbOperations.update");
    }

    public void batchInsert() throws SQLException, InterruptedException {
            Map<String, Customer> customerMap = new HashMap<>();
            int maxCno = 0;
            logger.info("Start -> DbOperations.batchInsert");
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection(BankJobTrigger.dbConnectionString,
                    BankJobTrigger.dbUsername, BankJobTrigger.password, BankJobTrigger.dbDriver);
            logger.info("Connection successfull");
            PreparedStatement ps = connection.prepareStatement(QueryConstants.GET_MAX_CNO);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                maxCno = rs.getInt("cno");
            }
            while (BankJobTrigger.count <= maxCno) {
                String cnosString = "";
                for (int j = 0;
                     j < BankJobTrigger.batchInsertCount && BankJobTrigger.count <= maxCno;
                     BankJobTrigger.count++, j++) {
                    cnosString = cnosString+","+BankJobTrigger.count;
                }
                cnosString = cnosString.replaceFirst(",","");
                customerMap = getCustomerDetails(connection, QueryConstants.GET_CUSTOMERS, cnosString);
                saveToFirebase(customerMap);
            }
            logger.info("End -> DbOperations.batchInsert");
    }

    public Map<String, Customer> getCustomerDetails(Connection con, String sql, String cnos) throws SQLException {
        logger.info("Start -> DbOperations.getCustomerDetails");
        Map<String, Customer> customerMap = new HashMap<>();
        sql = sql + "(" + cnos + ")";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Customer customer = new Customer();
            customer.setCno(rs.getString("cno"));
            customer.setFirstName(rs.getString("name"));
            customer.setLastName(rs.getString("fname"));
            customer.setType(rs.getString("type"));

            customer.setShares(getShares(con, QueryConstants.GET_SHARES, customer.getCno()));
            customer.setSavingBanks(getSavingBank(con, QueryConstants.GET_SAVING_BANK, customer.getCno()));
            customer.setRemainingAcctMap(getPigmyAndFD(con, QueryConstants.GET_REM_ACCT,customer.getCno()));
            customerMap.put(rs.getString("cno"), customer);
            logger.info("Fetching details of customer - "+customer.getCno());
        }

        logger.info("Start -> DbOperations.getCustomerDetails");
        return customerMap;
    }

    private Map<String, List<SavingBank>> getSavingBank(Connection con, String sql, String cno) throws SQLException {
        logger.info("Start -> DbOperations.getSavingBank");
        Map<String, List<SavingBank>> savingBanks = new HashMap<>();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cno);
        ResultSet rs = ps.executeQuery();
        String previousAcctNo="";
        String currentAcctNo="";
        int tranCount = 0;
        while (rs.next()){
            currentAcctNo = rs.getString("sb_ano");
            if (previousAcctNo.isEmpty()) {
                previousAcctNo = currentAcctNo;
            }
            if (previousAcctNo.equals(currentAcctNo) && tranCount < BankJobTrigger.transactionHistoryCount){
                SavingBank sb = setSavingBank(rs);
                addToMap(savingBanks, sb);
                tranCount++;
            } else if (!previousAcctNo.equals(currentAcctNo)){
                previousAcctNo = currentAcctNo;
                SavingBank sb = setSavingBank(rs);
                addToMap(savingBanks, sb);
                tranCount = 0;
            }

        }
        logger.info("End -> DbOperations.getSavingBank");
        return savingBanks;
    }

    public List<Share> getShares(Connection con, String sql, String cno) throws SQLException {
        logger.info("Start -> DbOperations.getShares");
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,cno);
        List<Share> shares = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        if (null != rs) {
            while (rs.next()) {
                Share share = new Share();
                share.setCno(rs.getString("cno"));
                share.setAcctNo(rs.getString("st_acno"));
                share.setBal(rs.getString("st_bal"));
                share.setSt_dot(rs.getString("st_dot"));
                share.setSt_part(rs.getString("st_part"));
                shares.add(share);
            }
        } else {
            logger.info("Result is null");
        }
        logger.info("End -> DbOperations.sql");
        return shares;
    }

    public Map<String, Map<String,List<RemainingAcct>>> getPigmyAndFD(Connection con, String sql, String cno) throws SQLException {
        logger.info("Start -> DbOperations.getPigmy");
        Map<String, Map<String,List<RemainingAcct>>> pigmyMap = new HashMap<>();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cno);
        ps.setString(2, cno);
        ps.setString(3, cno);
        ResultSet rs = ps.executeQuery();
        String previousAcctNo="";
        String currentAcctNo="";
        int tranCount = 0;
        while (rs.next()){
            currentAcctNo = rs.getString("sb_ano");
            if (previousAcctNo.isEmpty()) {
                previousAcctNo = currentAcctNo;
            }
            if (previousAcctNo.equals(currentAcctNo) && tranCount < BankJobTrigger.transactionHistoryCount) {
                RemainingAcct remainingAcct = setRemainingAcct(rs);
                addToMap(pigmyMap, remainingAcct);
                tranCount++;
            } else if ((!previousAcctNo.equals(currentAcctNo))){
                previousAcctNo = currentAcctNo;
                RemainingAcct remainingAcct = setRemainingAcct(rs);
                addToMap(pigmyMap, remainingAcct);
                tranCount = 0;
            }
        }
        logger.info("End -> DbOperations.getPigmy");
        return pigmyMap;
    }

    private SavingBank setSavingBank(ResultSet rs) throws SQLException {
        SavingBank sb = new SavingBank();
        sb.setSb_ano(rs.getString("sb_ano"));
        sb.setHead(rs.getString("head"));
        sb.setSb_bal(rs.getString("sb_bal"));
        sb.setSb_cr(rs.getString("sb_cr"));
        sb.setSb_db(rs.getString("sb_db"));
        sb.setSb_dot(rs.getString("sb_dot"));
        sb.setSb_part(rs.getString("sb_part"));
        return sb;
    }
    private RemainingAcct setRemainingAcct(ResultSet rs) throws SQLException {
        RemainingAcct remainingAcct = new RemainingAcct();
        remainingAcct.setSb_ano(rs.getString("sb_ano"));
        remainingAcct.setSb_ano(remainingAcct.getSb_ano().replaceAll("/","-"));
        remainingAcct.setHead(rs.getString("head"));
        remainingAcct.setSb_bal(rs.getString("sb_bal"));
        remainingAcct.setSb_dot(rs.getString("sb_dot"));
        remainingAcct.setSb_part(rs.getString("sb_part"));
        remainingAcct.setPg_dom(rs.getString("pg_dom"));
        remainingAcct.setPg_isd(rs.getString("pg_isd"));
        remainingAcct.setPg_con(rs.getString("pg_con"));
        remainingAcct.setPg_int(rs.getString("pg_int"));
        remainingAcct.setSb_val(rs.getString("sb_val"));

        logger.info(remainingAcct.getHead() + " - " + remainingAcct.getSb_ano());
        return remainingAcct;
    }

    private void addToMap(Map<String, Map<String, List<RemainingAcct>>> pigmyMap, RemainingAcct remainingAcct){
        if (pigmyMap.containsKey(remainingAcct.getHead())){
            Map<String, List<RemainingAcct>> remainingAcctMap = pigmyMap.get(remainingAcct.getHead());
            if (remainingAcctMap.containsKey(remainingAcct.getSb_ano())){
                List<RemainingAcct> remainingAcctList = remainingAcctMap.get(remainingAcct.getSb_ano());
                remainingAcctList.add(remainingAcct);
            } else {
                List<RemainingAcct> remainingAcctList = new ArrayList<>();
                remainingAcctList.add(remainingAcct);
                remainingAcctMap.put(remainingAcct.getSb_ano(), remainingAcctList);
            }
        } else {
            Map<String, List<RemainingAcct>> remainingAcctMap = new HashMap<>();
            List<RemainingAcct> remainingAcctList = new ArrayList<>();
            remainingAcctList.add(remainingAcct);
            remainingAcctMap.put(remainingAcct.getSb_ano(), remainingAcctList);
            pigmyMap.put(remainingAcct.getHead(), remainingAcctMap);
        }
    }

    private void addToMap(Map<String, List<SavingBank>> savingBankMap, SavingBank sb){
        if (savingBankMap.containsKey(sb.getSb_ano())){
            List<SavingBank> savingBankList = savingBankMap.get(sb.getSb_ano());
            savingBankList.add(sb);
        } else {
            List<SavingBank> savingBankList = new ArrayList<>();
            savingBankList.add(sb);
            savingBankMap.put(sb.getSb_ano(), savingBankList);
        }
    }

    public void saveToFirebase(Map<String, Customer> customerMap) throws InterruptedException {
        logger.info("SAVING TO FIREBASE - "+customerMap.size());
        Firebase firebase = new Firebase();
        FirebaseDatabase firebaseDatabase = firebase.getFirebaseDatabase();
        update(firebaseDatabase, customerMap);
        firebaseDatabase.getApp().delete();
    }
}

