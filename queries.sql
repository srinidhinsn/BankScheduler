2021-11-20 13:27:03 IST LOG:  statement: select * from customer where cno = 1321;
2021-11-20 13:27:03 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 24820) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:03 IST LOG:  statement: show max_identifier_length
2021-11-20 13:27:03 IST LOG:  statement: select ta.attname, ia.attnum, ic.relname, n.nspname, tc.relname from pg_catalog.pg_attribute ta, pg_catalog.pg_attribute ia, pg_catalog.pg_class tc, pg_catalog.pg_index i, pg_catalog.pg_namespace n, pg_catalog.pg_class ic where tc.oid = 24820 AND tc.oid = i.indrelid AND n.oid = tc.relnamespace AND i.indisprimary = 't' AND ia.attrelid = i.indexrelid AND ta.attrelid = i.indrelid AND ta.attnum = i.indkey[ia.attnum-1] AND (NOT ta.attisdropped) AND (NOT ia.attisdropped) AND ic.oid = i.indexrelid order by ia.attnum
2021-11-20 13:27:03 IST LOG:  statement: select oid, typbasetype from pg_type where typname = 'lo'
2021-11-20 13:27:03 IST LOG:  statement: set client_encoding to 'WIN1252'
2021-11-20 13:27:03 IST LOG:  statement: select * from custadd where cno = 1321;
2021-11-20 13:27:03 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 24814) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:03 IST LOG:  statement: show max_identifier_length
2021-11-20 13:27:03 IST LOG:  statement: select ta.attname, ia.attnum, ic.relname, n.nspname, tc.relname from pg_catalog.pg_attribute ta, pg_catalog.pg_attribute ia, pg_catalog.pg_class tc, pg_catalog.pg_index i, pg_catalog.pg_namespace n, pg_catalog.pg_class ic where tc.oid = 24814 AND tc.oid = i.indrelid AND n.oid = tc.relnamespace AND i.indisprimary = 't' AND ia.attrelid = i.indexrelid AND ta.attrelid = i.indrelid AND ta.attnum = i.indkey[ia.attnum-1] AND (NOT ta.attisdropped) AND (NOT ia.attisdropped) AND ic.oid = i.indexrelid order by ia.attnum
2021-11-20 13:27:03 IST LOG:  statement: select * from customer where cno = 1321;
2021-11-20 13:27:03 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 24820) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:04 IST LOG:  statement: select * from macct where type = 'SHARE'
2021-11-20 13:27:04 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 25374) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:04 IST LOG:  statement: select * from sh_master where cno = 1321 and head = 'SH'
2021-11-20 13:27:04 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 25581) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:04 IST LOG:  statement: select * from sh_trans where st_acno = '10100100001321' and head = 'SH' order by cou asc;
2021-11-20 13:27:04 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 25587) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:04 IST LOG:  statement: select * from macct where type = 'CALLDEP'
2021-11-20 13:27:04 IST LOG:  statement: select * from sb_master where cno = 1321 and head = 'SB'
2021-11-20 13:27:04 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 25521) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:04 IST LOG:  statement: select * from sb_master where cno = 1321 and head = 'KDS'
2021-11-20 13:27:04 IST LOG:  statement: select * from macct where type = 'CUMPIG'
2021-11-20 13:27:04 IST LOG:  statement: select * from pig_master where cno = 1321 and head = 'PIGMY'
2021-11-20 13:27:04 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 25452) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:04 IST LOG:  statement: select * from pig_master where cno = 1321 and head = 'RD'
2021-11-20 13:27:04 IST LOG:  statement: select * from pig_master where cno = 1321 and head = 'RDA'
2021-11-20 13:27:04 IST LOG:  statement: select * from pig_master where cno = 1321 and head = 'RDB'
2021-11-20 13:27:04 IST LOG:  statement: select * from macct where type = 'FIXED' OR type = 'CASH'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321  and head = 'FDHYP'
2021-11-20 13:27:04 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 25014) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321  and head = 'LSD'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321  and head = 'FDMISSC'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321  and head = 'GFD'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321  and head = 'FDSC'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321  and head = 'GCC'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321  and head = 'FDMISG'
2021-11-20 13:27:04 IST LOG:  statement: select * from macct where type = 'FIXED' OR type = 'CASH'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321 and head = 'FDHYP'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321 and head = 'LSD'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321 and head = 'FDMISSC'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321 and head = 'GFD'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321 and head = 'FDSC'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321 and head = 'GCC'
2021-11-20 13:27:04 IST LOG:  statement: select * from fd_master where cno = 1321 and head = 'FDMISG'
2021-11-20 13:27:04 IST LOG:  statement: select * from macct where type = 'CUMPIG'
2021-11-20 13:27:04 IST LOG:  statement: select * from pig_master where cno = 1321 and head = 'PIGMY'
2021-11-20 13:27:04 IST LOG:  statement: select * from pig_master where cno = 1321 and head = 'RD'
2021-11-20 13:27:04 IST LOG:  statement: select * from pig_master where cno = 1321 and head = 'RDA'
2021-11-20 13:27:04 IST LOG:  statement: select * from pig_master where cno = 1321 and head = 'RDB'
2021-11-20 13:27:04 IST LOG:  statement: select * from macct where type = 'LOANS'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'MTL'
2021-11-20 13:27:04 IST LOG:  statement: select n.nspname, c.relname, a.attname, a.atttypid, t.typname, a.attnum, a.attlen, a.atttypmod, a.attnotnull, c.relhasrules, c.relkind, c.oid, pg_get_expr(d.adbin, d.adrelid), case t.typtype when 'd' then t.typbasetype else 0 end, t.typtypmod, c.relhasoids from (((pg_catalog.pg_class c inner join pg_catalog.pg_namespace n on n.oid = c.relnamespace and c.oid = 25638) inner join pg_catalog.pg_attribute a on (not a.attisdropped) and a.attnum > 0 and a.attrelid = c.oid) inner join pg_catalog.pg_type t on t.oid = a.atttypid) left outer join pg_attrdef d on a.atthasdef and d.adrelid = a.attrelid and d.adnum = a.attnum order by n.nspname, c.relname, attnum
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'LIC'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'GOODS'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'HCC'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'DLC'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'NSCKVP'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'SECC'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'VL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'STL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'MPL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'GL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'EDL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'HCR'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'JL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'SECR'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'SL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'SPL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'SRL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'SSPL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'HPL'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where cno = 1321  and head = 'SCL'
2021-11-20 13:27:04 IST LOG:  statement: select * from macct where type = 'LOANS'
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'MTL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'LIC';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'GOODS';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'HCC';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'DLC';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'NSCKVP';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'SECC';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'VL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'STL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'MPL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'GL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'EDL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'HCR';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'JL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'SECR';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'SL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'SPL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'SRL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'SSPL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'HPL';
2021-11-20 13:27:04 IST LOG:  statement: select * from sl_master where ((hl_surh1 = 'SH') and (hl_sur1mno = '10100100001321') or (hl_surh2 = 'SH') and (hl_sur2mno = '10100100001321')) and head = 'SCL';
