package com.smartfox.managedbean;

import lombok.Data;

import javax.faces.bean.ManagedBean;

/**
 * Created by hdargaye on 15/02/2019.
 */

@ManagedBean(name = "userManagedBean")
@Data
public class UserManagedBean {

    public String username = "Haidar";

}
