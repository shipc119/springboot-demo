package com.shipc.demo.test.controller;

import com.shipc.demo.test.orm.sys.dto.UserCreateInDTO;
import com.shipc.demo.test.service.sys.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description
 * @Author shipc
 * @Date 2019/5/22 19:41
 * @Version 1.0
 */
@Api(tags = "用户操作接口")
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "创建用户")
    @PostMapping
    public void create(@RequestBody UserCreateInDTO dto) {
        userService.add(dto);
    }
}
