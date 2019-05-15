package com.shipc.demo.test.service.sys;

import com.shipc.demo.test.orm.sys.domain.User;
import com.shipc.demo.test.orm.sys.domain.UserFactory;
import com.shipc.demo.test.orm.sys.dto.UserCreateInDTO;
import com.shipc.demo.test.orm.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description
 * @Author shipc
 * @Date 2019/5/15 19:33
 * @Version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public void add(UserCreateInDTO dto) {
        this.userMapper.add(UserFactory.build(dto));
    }

    public List<User> find() {
        return this.userMapper.find();
    }
}
