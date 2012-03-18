package com.dal;


import java.util.List;
import java.util.UUID;

public interface IDbMgr {
    void adduser(User user);
    void updateuser(User user);
    void adddeal(Deal deal);
    void deldeal(Deal deal);
    void updatedeal(Deal deal);
    List<Deal> search(String str);
    UUID validate(String username, String passwd);
    User displayProfile(String username,String passwd);

}

