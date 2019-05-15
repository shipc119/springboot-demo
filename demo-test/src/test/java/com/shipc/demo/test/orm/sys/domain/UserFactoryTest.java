package com.shipc.demo.test.orm.sys.domain;

import com.shipc.demo.test.orm.sys.dto.UserCreateInDTO;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @ClassName UserFactoryTest
 * @Description
 * @Author shipc
 * @Date 2019/5/15 19:28
 * @Version 1.0
 */
@SpringBootTest
public class UserFactoryTest {

    @Test
    public void build() {
        UserCreateInDTO dto = new UserCreateInDTO();
        dto.setUserName("admin");
        dto.setPassword("admin123");

        User build = UserFactory.build(dto);
        assertNotNull(build);
        assertEquals("admin", build.getUserName());
        assertEquals("admin123", build.getPassword());
    }
}
