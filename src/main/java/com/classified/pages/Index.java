package com.classified.pages;

import com.dal.DbMgr;
import com.dal.Deal;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.StreamResponse;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.net.URISyntaxException;
import java.util.List;

import static com.Utils.bytes2Image;

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


    @Inject
    private ComponentResources resources;

    public StreamResponse onImage() {
        return bytes2Image(deal.getImage());
    }

    public Link getPicUrl() throws Exception {
        return resources.createEventLink("image", new Object[]{});
    }

    void onSelectedFromSubmit() throws URISyntaxException {
        alertManager.info("searching for:" + searchText);
        deals = DbMgr.getInstance().search(searchText);
    }
}
