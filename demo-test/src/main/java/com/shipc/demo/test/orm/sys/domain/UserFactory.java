package com.shipc.demo.test.orm.sys.domain;

import com.shipc.demo.test.orm.sys.dto.UserCreateInDTO;

/**
 * @ClassName UserFactory
 * @Description
 * @Author shipc
 * @Date 2019/5/15 19:26
 * @Version 1.0
 */
public class UserFactory {

    public static User build(UserCreateInDTO dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        return user;
    }
}
