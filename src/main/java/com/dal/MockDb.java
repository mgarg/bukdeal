package com.dal;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MockDb implements IDbMgr {

    List<Deal> deals = new ArrayList<Deal>();
    public MockDb(){
        Deal d1 =  new Deal(), d2 = new Deal();
        d1.setName("os by galvin");
        d2.setName("programming languages");
        deals.add(d1);
        deals.add(d2);
    }
    public void adduser(User user) {

    }

    public void updateuser(User user, String mobile, String email) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updateuser(User user) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void adddeal(Deal deal) {
        deals.add(deal);

    }

    public void deldeal(Deal deal) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updatedeal(Deal deal, String mobile, String password) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void updatedeal(Deal deal) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Deal> search(String str) {
        if(str.equals("all"))
            return deals;

        List<Deal> result = new ArrayList<Deal>();

        String st = str.toLowerCase();
        for(Deal d: deals){
            if(d.getName().contains(st))
                result.add(d);
        }
        return result;
    }

    public UUID validate(String username, String passwd) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public User displayProfile(String username, String passwd) {
        return null;//To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean passwordConfirmed(String password1, String password2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public byte[] findBookImage(UUID id) {
        return new byte[0];  //To change body of implemented methods use File | Settings | File Templates.
    }


}
