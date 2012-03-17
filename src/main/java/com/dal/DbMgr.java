package com.dal;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import java.util.UUID;

public class DbMgr {
    static MysqlConnectionPoolDataSource dataSource;
    static {
        dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("bukdb");
    }

    static IDbMgr dbMgr = new Sqldb(dataSource);

    public static IDbMgr getInstance(){

        return dbMgr;
    }
}
