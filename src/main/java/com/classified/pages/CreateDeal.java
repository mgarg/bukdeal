package com.classified.pages;

import com.dal.DbMgr;
import com.dal.Deal;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.upload.services.UploadedFile;

import java.util.UUID;

import static com.Utils.image2bytes;

public class CreateDeal
{
    @Persist
    @Property
    private Deal deal;

    @Inject
    private AlertManager alertManager;

    @Persist
    @Property
    private String username, passwd;


    @Persist
    @Property
    private UploadedFile file;

    @Component
    private BeanEditForm form;

    void onValidate() {

    }

    void onSubmit() {
        deal.setId(UUID.randomUUID());
        deal.setUserid(DbMgr.getInstance().validate(username, passwd));
        deal.setImage(image2bytes(file));
        DbMgr.getInstance().adddeal(deal);
        alertManager.info("deal added");
        deal = null;
    }
}
