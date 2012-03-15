import com.mysql.jdbc.Driver;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

        jdbcTemplate.update(
                "insert into actor (name, surname) values (?, ?)",
                "Leonor", "Watling");
    }

    private static MysqlConnectionPoolDataSource getDataSource() {
        MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setDatabaseName("bukdeal");
        return dataSource;
    }
}
