package com.dal;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

public class DbMgr {

    public static BasicDataSource herokuDataSource() throws URISyntaxException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);

        return basicDataSource;
    }

    static DataSource localDataSource(){
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("bukdb");
        return dataSource;
    }

    static IDbMgr dbMgr;

    public static IDbMgr getInstance()  {

        if(dbMgr == null)
            dbMgr =  new Sqldb(localDataSource());
        return dbMgr;
    }
}
