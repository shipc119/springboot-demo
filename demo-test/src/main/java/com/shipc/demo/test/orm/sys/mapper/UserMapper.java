package com.shipc.demo.test.orm.sys.mapper;

import com.shipc.demo.test.orm.sys.domain.User;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description
 * @Author shipc
 * @Date 2019/5/15 19:10
 * @Version 1.0
 */
public interface UserMapper {

    void add(User user);

    int updateById(User user);

    List<User> find();

    User getById(Long uuid);

    int deleteById(Long uuid);
}
