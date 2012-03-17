import com.dal.Sqldb;
import com.dal.User;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import java.sql.SQLException;
import java.util.UUID;

public class Main {
    public static void main(String args[]) throws SQLException {

        Sqldb sqldb = new Sqldb(getDataSource());
       
//        List<Deal> deals = sqldb.search("cormen");
//        for(Deal d:deals)
//            System.out.println(d.getName()+" "+d.getAuthor());
//        Deal d = new Deal();
//        d.setName("digital");
//        d.setAuthor("mano");
//        d.setId(UUID.randomUUID());
//        sqldb.adddeal(d);
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setUsername("agarg");
        user.setPassword("test2");
        sqldb.adduser(user);
        System.out.println(sqldb.validate("agarg", "test2"));
        System.out.println(user.getId());
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
