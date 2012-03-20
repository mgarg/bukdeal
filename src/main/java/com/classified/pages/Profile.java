package com.classified.pages;

import com.dal.DbMgr;
import com.dal.User;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Profile
{
    @Persist
    @Property
    private String username, password, mobile, email;

    @Persist @Property private User user;

    @Inject
    private AlertManager alertManager;

    @Persist
    @Property
    private boolean enableMobile, enableEmail;

    void onSelectedFromUserSubmit() {

        if(!enableEmail) {

            user = DbMgr.getInstance().displayProfile(username, password);
            if(user==null)
                alertManager.error("incorrect username or password");
            else {
                mobile = user.getMobile();
                email = user.getEmail();
                enableEmail = true;
                enableMobile = true;
                alertManager.info("user may now update his mobile/email ");
            }
        }
        else {
            DbMgr.getInstance().updateuser(user, mobile, email);
            enableEmail = false;
            enableMobile = false;
            username = null;
            password = null;
            email = null;
            mobile = null;
        }
    }
}
