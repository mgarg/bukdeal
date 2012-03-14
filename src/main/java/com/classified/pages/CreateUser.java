package com.classified.pages;

import com.dal.DbMgr;
import com.dal.User;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.validator.Email;

public class CreateUser
{
    @Persist
    @Property
    private User user;

    @Inject
    private AlertManager alertManager;


    @Component
    private BeanEditForm form;

    void onValidate() {

    }
    
    void onSuccess()
    {
//        DbMgr db;
//        db.adduser(user);
        alertManager.info("user added");
    }
}
