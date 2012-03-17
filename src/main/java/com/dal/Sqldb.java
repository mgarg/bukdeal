package com.dal;


import com.Utils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.Utils.uuid2Bytes;

public class Sqldb implements IDbMgr{
    DataSource d;
   public Sqldb(DataSource d)
    {
        this.d = d;    
    }
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(this.d);
    }
    
    public void adduser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateuser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void adddeal(Deal deal) {
        jdbcTemplate().update(
                "INSERT INTO deal (id,name,author,edition,publisher,status,price) values (?,?,?,?,?,?,?)",
                uuid2Bytes(deal.getId()), deal.getName(),deal.getAuthor(),deal.getEdition(),deal.getPublisher(),deal.getStatus(),deal.getPrice());
    }

    public void deldeal(Deal deal) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updatedeal(Deal deal) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    //SELECT name,author,publisher FROM deal WHERE MATCH(name,author,publisher) AGAINST ('cormen');
    //name = '%s'"
    public List<Deal> search(String str) {
       // String q = String.format("SELECT * FROM deal WHERE MATCH(name,author,publisher) AGAINST ('%s')" , str);
        List<Deal> deals = this.jdbcTemplate().query(
                "SELECT * FROM deal WHERE MATCH(name,author,publisher) AGAINST (?)",
                //"SELECT * FROM deal WHERE name = ?",
                new Object[]{str},
                new RowMapper<Deal>() {
                    public Deal mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Deal deal = new Deal();
                        deal.setName(rs.getString("name"));
                        deal.setAuthor(rs.getString("author"));
                        return deal;
                    }
                });
        return deals;
    }
}
