package com.wisn.mvx.demo1.presenter;

import com.wisn.mvx.demo1.bean.UserBean;
import com.wisn.mvx.demo1.model.IUserModule;
import com.wisn.mvx.demo1.model.UserModule;
import com.wisn.mvx.demo1.view.IUserView;

/**
 * @author Wisn
 * @time 2018/1/24 10:27
 */


public class UserPresenter {
    private IUserView  userView;
    private IUserModule userModule;

    public UserPresenter(IUserView  userView){
        this.userView=userView;
        userModule=new UserModule();
    }

    public void saveUser(){
        userModule.setId(userView.getId());
        userModule.setFirstName(userView.getFirstName());
        userModule.setLastName(userView.getLastName());
    }
    public void loadUser(int id){
        UserBean userBean = userModule.loadUser(id);
        userView.setFirstName(userBean.getmFirstName());
        userView.setLastName(userBean.getmLastName());
    }


}
