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

import static com.Utils.*;

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

    public void updateuser(User user,String mobile,String email) {
        jdbcTemplate().update(
         "UPDATE user SET mobile = (?),email = (?) WHERE mobile = (?),email = (?)",mobile,email, user.getMobile(),user.getEmail()
        );
//        jdbcTemplate().update(
//                "UPDATE user SET email = (?) WHERE email = (?)",email, user.getEmail()
//        );
    }

    public void adddeal(Deal deal) {
        jdbcTemplate().update(
                "INSERT INTO deal (id,userid,name,author,edition,publisher,status,price,image) values (?,?,?,?,?,?,?,?,?)",
                uuid2Bytes(deal.getId()),uuid2Bytes(deal.getUserid()),deal.getName(),deal.getAuthor(),deal.getEdition(),deal.getPublisher(),deal.getStatus(),deal.getPrice(),deal.getImage());
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
                        deal.setImage(rs.getBytes("image"));
                        if(deal.getImage() == null)
                            deal.setImage(defaultImg());
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
    public User displayProfile(String username,String passwd){
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwd);
        
        try{
            Map<String, Object> res = jdbcTemplate().queryForMap("SELECT id,mobile,email FROM user WHERE username =(?) AND password =(?)", username, passwd);
            user.setId(bytes2Uuid((byte[])res.get("id")));
            user.setMobile((String) res.get("mobile"));
            user.setEmail((String) res.get("email"));

            return user;
        }
        catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public boolean passwordConfirmed(String password1, String password2) {
       // System.out.println(password1.equals(password2));
        return password1.equals(password2);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
