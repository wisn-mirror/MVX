package com.wisn.mvx.demo1.model;


import com.wisn.mvx.demo1.bean.UserBean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wisn
 * @time 2018/1/24 10:58
 */


public class UserModule implements IUserModule{
    private String firstName;
    private String lastName;
    private int id;
    private Map<Integer,UserBean> data=new HashMap<>();

    @Override
    public void setFirstName(String firstName) {
        this.firstName=firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName=lastName;
        data.put(id,new UserBean(this.firstName,this.lastName));
    }

    @Override
    public void setId(int in) {
        this.id=in;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public UserBean loadUser(int id) {
        return data.get(id);
    }
}
