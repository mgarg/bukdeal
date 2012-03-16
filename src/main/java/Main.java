import com.dal.Deal;
import com.dal.Sqldb;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String args[]) throws SQLException {

        Sqldb sqldb = new Sqldb(getDataSource());
        List<Deal> deals = sqldb.search("cormen");
        for(Deal d:deals)
            System.out.println(d.getName()+" "+d.getAuthor());
    }

    private static MysqlConnectionPoolDataSource getDataSource() {
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("bukdb");
        return dataSource;
    }
}
