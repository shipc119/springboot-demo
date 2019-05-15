package com.shipc.demo.test.orm.sys.dto;

/**
 * @ClassName UserCreateInDTO
 * @Description
 * @Author shipc
 * @Date 2019/5/15 19:25
 * @Version 1.0
 */
public class UserCreateInDTO {
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
