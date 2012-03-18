package com.classified.pages;

import com.dal.DbMgr;
import com.dal.User;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.net.URISyntaxException;

public class About
{
    @Persist
    @Property
    private String username;

    @Persist
    @Property
    private String password;

    @Persist
    @Property
    private User user;

    @Inject
    private AlertManager alertManager;

    public String getUserMobile() {
        return user.getMobile();
    }
    public String getUserEmail() {
        return user.getEmail();
    }
    void onSelectedFromSubmit()throws URISyntaxException {
        alertManager.info("profile of:" + username);
       // DbMgr.getInstance().validate(username,password);
        user = DbMgr.getInstance().displayProfile(username, password);
    }
}
