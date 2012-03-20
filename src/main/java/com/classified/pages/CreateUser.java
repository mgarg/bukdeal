package com.classified.pages;

import com.dal.DbMgr;
import com.dal.User;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.net.URISyntaxException;
import java.util.UUID;

public class CreateUser
{
//    @Persist
//    @Property
//    private User user;

    @Persist
    @Property
    private String name, username, password, mobile, email,confirmPassword;
    
    @Inject
    private AlertManager alertManager;


   // @Component
  //  private BeanEditForm form;

    //void onValidate() {

    //}
    
    void onSelectedFromSubmit()throws URISyntaxException {
//        IDbMgr db;
//        db.adduser(user);
        //make a constructor and give these as arguments
        User user = new User(name, username, password, mobile, email,UUID.randomUUID()) ;
//        user.setId(UUID.randomUUID());
//        user.setName(name);
//        user.setUsername(username);
//        user.setPassword(password);
//        user.setMobile(mobile);
//        user.setEmail(email);
        //IDbMgr instance = DbMgr.getInstance();
        if(DbMgr.getInstance().passwordConfirmed(password,confirmPassword)==false)
            alertManager.info("wrong password,please confirm password again");
        else{
            DbMgr.getInstance().adduser(user);
            alertManager.info("user added");
            name = null;
            username = null;
            password = null;
            mobile = null;
            email = null;
            confirmPassword = null;
        }

    }
}
