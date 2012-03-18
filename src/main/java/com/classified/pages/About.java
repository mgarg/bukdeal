package com.classified.pages;

import com.dal.DbMgr;
import com.dal.User;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class About
{
    @Persist
    @Property
    private String username, password, mobile, email;

    @Inject
    private AlertManager alertManager;

    @Persist
    @Property
    private boolean disableMobile, disableEmail;


    void onSelectedFromUserSubmit() {
        
        disableEmail = !disableEmail;
        disableMobile = !disableMobile;
        alertManager.info("disable = " + disableEmail);
       // DbMgr.getInstance().validate(username,password);
        User user = DbMgr.getInstance().displayProfile(username, password);
        if(user==null)
            alertManager.error("bad username or passwd");
        else {
            mobile = user.getMobile();
            email = user.getEmail();
        }
    }
}
