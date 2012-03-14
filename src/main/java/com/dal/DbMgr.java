package com.dal;


public interface DbMgr {
    void adduser(User user);
    void updateuser(User user);
    void adddeal(Deal deal);
    void deldeal(Deal deal);
    void updatedeal(Deal deal);
    
}
