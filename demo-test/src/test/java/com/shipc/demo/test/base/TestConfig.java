package com.shipc.demo.test.base;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TestConfig
 * @Description
 * @Author shipc
 * @Date 2019/5/9 19:21
 * @Version 1.0
 */
@Configuration
@Transactional(value = "")  // 事务
public class TestConfig {
}
