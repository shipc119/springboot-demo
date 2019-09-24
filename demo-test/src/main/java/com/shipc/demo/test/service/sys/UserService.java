package com.shipc.demo.test.service.sys;

import com.shipc.demo.test.orm.sys.domain.User;
import com.shipc.demo.test.orm.sys.domain.UserFactory;
import com.shipc.demo.test.orm.sys.dto.UserCreateInDTO;
import com.shipc.demo.test.orm.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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


    /**
     * @CachePut 应用到写数据的方法上，如新增/修改方法，调用方法时会自动把相应的数据放入缓存
     */
    @CachePut(value = "user")
    public void add(UserCreateInDTO dto) {
        this.userMapper.add(UserFactory.build(dto));
    }

    @CachePut(value = "user")
    public void update(Long uuid, UserCreateInDTO dto) {
        User user = this.userMapper.getById(uuid);
        this.userMapper.updateById(UserFactory.updateBuild(dto, user));
    }

    /**
     * @Cacheable 应用到读取数据的方法上，先从缓存中读取，如果没有再从DB获取数据，然后把数据添加到缓存中
     *            unless 表示条件表达式成立的话不放入缓存
     */
    @Cacheable(value = "user", unless = "#result eq null")
    public User getById(Long uuid) {
        return this.userMapper.getById(uuid);
    }

    /**
     * @CacheEvict 应用到删除数据的方法上，调用方法时会从缓存中删除对应的key的数据
     */
    @CacheEvict(value = "user", condition = "#result eq true")
    public boolean deleteById(Long uuid) {
        return this.userMapper.deleteById(uuid) > 0;
    }

    public List<User> find() {
        return this.userMapper.find();
    }
}
