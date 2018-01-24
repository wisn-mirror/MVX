package com.wisn.mvx.demo1.model;

import com.wisn.mvx.demo1.bean.UserBean;

/**
 * @author Wisn
 * @time 2018/1/24 10:25
 */


public interface IUserModule {
    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setId(int in);
    int getId();
    UserBean  loadUser(int id);
}
