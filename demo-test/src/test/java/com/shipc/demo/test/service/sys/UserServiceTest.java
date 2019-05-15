package com.shipc.demo.test.service.sys;

import com.shipc.demo.test.base.BaseTest;
import com.shipc.demo.test.orm.sys.domain.User;
import com.shipc.demo.test.orm.sys.dto.UserCreateInDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @ClassName UserServiceTest
 * @Description
 * @Author shipc
 * @Date 2019/5/15 19:34
 * @Version 1.0
 */
public class UserServiceTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void addTest() {
        UserCreateInDTO dto = new UserCreateInDTO();
        dto.setUserName("admin");
        dto.setPassword("admin123");

        userService.add(dto);

        List<User> users = userService.find();
        assertNotNull(users);
        assertFalse(users.isEmpty());
        assertEquals(1, users.size());
        assertEquals("admin", users.get(0).getUserName());
        assertEquals("admin123", users.get(0).getPassword());
    }
}
