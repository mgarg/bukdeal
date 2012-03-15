package com.classified.pages;

import java.util.List;

import com.dal.DbMgr;
import com.dal.IDbMgr;
import com.dal.Deal;
import org.apache.tapestry5.annotations.*;
import org.apache.tapestry5.ioc.annotations.*;
import org.apache.tapestry5.alerts.AlertManager;

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

    void onSelectedFromSubmit(){
        alertManager.info("searching for:" + searchText);
        deals = DbMgr.getInstance().search(searchText);
    }
}
