package com.distarise.bank.model;

public enum AccountTypes {
    SHARE("SHARE","SH"),
    SB("CALLDEP", "SB"),
    KDS("CALLDEP","KDS"),
    PIGMY("CUMPIG","PIGMY"),
    RD("CUMPIG","RD"),
    RDA("CUMPIG","RDA"),
    RDB("CUMPIG","RDB"),
    GCC("CASH","GCC"),
    FDHYP("FIXED","FDHYP"),
    LSD("FIXED","LSD"),
    FDMISSC("FIXED","FDMISSC"),
    GFD("FIXED","GFD"),
    FDSC("FIXED","FDSC"),
    FDMISG("FIXED","FDMISG"),
    MTL("LOANS","MTL"),
    LIC("LOANS","LIC"),
    GOODS("LOANS","GOODS"),
    HCC("LOANS","HCC"),
    DLC("LOANS","DLC"),
    NSCKVP("LOANS","NSCKVP"),
    SECC("LOANS","SECC"),
    VL("LOANS","VL"),
    STL("LOANS","STL"),
    MPL("LOANS","MPL"),
    GL("LOANS","GL"),
    EDL("LOANS","EDL"),
    HCR("LOANS","HCR"),
    JL("LOANS","JL"),
    SECR("LOANS","SECR"),
    SL("LOANS","SL"),
    SPL("LOANS","SPL"),
    SRL("LOANS","SRL"),
    SSPL("LOANS","SSPL"),
    HPL("LOANS","HPL"),
    SCL("LOANS","SCL");

    AccountTypes(String type, String acct) {
    }
}
