package com.dal;

public class DbMgr {
    static IDbMgr dbMgr = new MockDb();

    public static IDbMgr getInstance(){
        return dbMgr;
    }
}
