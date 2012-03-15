package com.dal;


import java.util.ArrayList;
import java.util.List;

public interface IDbMgr {
    void adduser(User user);
    void updateuser(User user);
    void adddeal(Deal deal);
    void deldeal(Deal deal);
    void updatedeal(Deal deal);
    List<Deal> search(String str);
}

