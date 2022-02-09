package com.distarise.bank.database;

public class QueryConstants {
    public static String GET_MAX_CNO = "select max(cno) as cno from customer";
    public static String GET_CUSTOMERS = "select cno, name, fname, type from customer where cno in ";
    public static String GET_SHARES = "select cno,st_acno,st_bal,st_dot,st_part from sh_trans where cno=? and head = 'SH' order by st_dot desc";
    public static String GET_SAVING_BANK= "select sb_ano, sb_cr, sb_db, sb_bal, sb_dot, sb_part, head from sb_trans where sb_ano in (select sb_ano from sb_master where cno=?) order by sb_ano, sb_dot desc";
    public static String GET_PIGMIES = "select tran.sb_ano, tran.sb_bal, tran.sb_dot, tran.sb_part, tran.head, " +
            " master.pg_dom, master.pg_isd, master.pg_con, master.pg_int " +
            " from sb_trans tran, pig_master master where tran.sb_ano = master.pg_acno and " +
            " master.cno = ? and master.pg_dom >= sysdate order by tran.sb_ano, tran.sb_dot desc";

    public static String GET_REM_ACCT = "select fd.fd_acno as sb_ano, fd.fd_prin as sb_bal,sysdate as sb_dot, 'Renewal' as sb_part, m.head as head,"+
    " fd.fd_dor as pg_dom, fd.fd_doa as pg_isd, fd.fd_prin as pg_con, fd.fd_int as pg_int, fd.fd_amt as sb_val from fd_dep_det fd, fd_master m where"+
    " m.fd_acno=fd.fd_acno and fd.fd_dor >= sysdate and m.fd_stat <> 'CLOSED' and m.cno = ? "+
    " union"+
    " select m.hl_lano as sb_ano,l.sl_bal as sb_bal, l.sl_dot as sb_dot, l.sl_part as sb_part, l.head as head," +
    " sysdate as pg_dom, sysdate as pg_isd, '0' as pg_con, '0' as pg_int, '0' as sb_val " +
    " from sl_master m, sl_ledger l where m.hl_lano =l.sl_ano and m.hl_stat <> 'CLOSED' and  m.cno=? "+
    " union"+
    " select tran.sb_ano, tran.sb_bal, tran.sb_dot, tran.sb_part, tran.head, master.pg_dom, master.pg_isd, master.pg_con, master.pg_int, '0' as  sb_val"+
    " from sb_trans tran, pig_master master where tran.sb_ano = master.pg_acno and"+
    " master.pg_dom >= sysdate and master.cno = ? order by sb_ano, sb_dot desc";
}
