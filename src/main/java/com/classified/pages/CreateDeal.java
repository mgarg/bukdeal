package com.classified.pages;

import com.dal.DbMgr;
import com.dal.Deal;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.net.URISyntaxException;
import java.util.UUID;

public class CreateDeal
{
    @Persist
    @Property
    private Deal deal;

    @Inject
    private AlertManager alertManager;

    @Persist
    @Property
    private String username,passwd;

    @Component
    private BeanEditForm form;

    void onValidate() {

    }
    
    void onSubmit() throws URISyntaxException {
        deal.setId(UUID.randomUUID());
        deal.setUserid(DbMgr.getInstance().validate(username, passwd));
        //alertManager.info(passwd);
        DbMgr.getInstance().adddeal(deal);
        alertManager.info("deal added");
        deal = null;
    }
}
