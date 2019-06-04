package com.shipc.demo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

/**
 *
 * @author shipc 2019/5/9 19:35
 * @version 1.0
 */
@EnableCaching  // 开启缓存
@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        try {
            SpringApplicationBuilder builder = new SpringApplicationBuilder(App.class);
            builder.web(WebApplicationType.SERVLET).run(args);
//            ConfigurableApplicationContext context = builder.web(WebApplicationType.SERVLET).run(args);
//            String[] profiles = context.getEnvironment().getActiveProfiles();
            log.info("---------Start Application---------");
        } catch (Exception e) {
            log.error("启动异常", e);
        }
    }
}
