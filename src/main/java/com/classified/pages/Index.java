package com.classified.pages;

import com.dal.DbMgr;
import com.dal.Deal;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.net.URISyntaxException;
import java.util.List;

public class Index
{
    @Persist
    @Property
    private String searchText;

    @Inject
    private AlertManager alertManager;


    @Persist
    @Property
    private List<Deal> deals;

    @Persist
    @Property
    private Deal deal;

    void onSelectedFromSubmit() throws URISyntaxException {
        alertManager.info("searching for:" + searchText);
        deals = DbMgr.getInstance().search(searchText);
    }
}
