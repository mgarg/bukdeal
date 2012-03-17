package com.dal;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.Utils.bytes2Uuid;
import static com.Utils.uuid2Bytes;

public class Sqldb implements IDbMgr{
    DataSource d;
   public Sqldb(DataSource d)
    {
        this.d = d;
        
    }
    
    void InitTables()
    {
        JdbcTemplate db = jdbcTemplate();
        
        db.update(
                "ALTER TABLE user ADD varchar(4000) name "
        );
    }
    JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(this.d);
    }
    
    public void adduser(User user) {
        jdbcTemplate().update(
                "INSERT INTO user(id,name,username,password,mobile,email) values (?,?,?,?,?,?)",
                uuid2Bytes(user.getId()),user.getName(),user.getUsername(),user.getPassword(),user.getMobile(),user.getEmail());
    }

    public void updateuser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void adddeal(Deal deal) {
        jdbcTemplate().update(
                "INSERT INTO deal (id,userid,name,author,edition,publisher,status,price) values (?,?,?,?,?,?,?,?)",
                uuid2Bytes(deal.getId()),uuid2Bytes(deal.getUserid()),deal.getName(),deal.getAuthor(),deal.getEdition(),deal.getPublisher(),deal.getStatus(),deal.getPrice());
    }

    public void deldeal(Deal deal) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updatedeal(Deal deal) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Deal> search(String str) {
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
    public UUID validate(String username, String passwd){
        try{
        Map<String, Object> res = jdbcTemplate().queryForMap("SELECT id FROM user WHERE username =(?) AND password =(?)", username, passwd);
        byte [] bytes= (byte[])res.get("id");

        return bytes2Uuid(bytes);
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}
