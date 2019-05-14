package com.shipc.demo.test.base;

import ai.grakn.redismock.RedisServer;
import com.shipc.demo.test.AppTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @ClassName BaseTest
 * @Description
 * @Author shipc
 * @Date 2019/5/9 19:13
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@Ignore   // 忽略测试
@SpringBootTest(classes = AppTest.class)  //配置启动类
public class BaseTest {

    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);

    // 测试内嵌redis服务
    private static RedisServer server = null;

    @BeforeClass
    public static void setRedisServer() throws IOException {
        log.info("--------测试：内嵌redis----------");
        server = new RedisServer(6380);
        server.start();
        log.info("-------内嵌redis启动成功：host=" + server.getHost());
    }

    @AfterClass
    public static void outRedisServer() {
        server.stop();
        server = null;
        log.info("-------关闭内嵌redis服务-------");
    }
}
