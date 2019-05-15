package com.shipc.demo.test.orm.sys.domain;

/**
 * @ClassName User
 * @Description
 * @Author shipc
 * @Date 2019/5/15 19:07
 * @Version 1.0
 */
public class User {

    private Long uuid;

    private String userName;

    private String password;

    public Long getUuid() {
        return uuid;
    }

    void setUuid(Long uuid) {
        this.uuid = uuid;
    }

    public String getUserName() {
        return userName;
    }

    void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }
}
