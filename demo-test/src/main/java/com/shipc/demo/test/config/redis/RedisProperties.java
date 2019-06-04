package com.shipc.demo.test.config.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @ClassName RedisProperties
 * @Description
 * @Author shipc
 * @Date 2019/5/23 19:46
 * @Version 1.0
 */
@Component                                       // 标记本类为一个Bean，可以使用@Autowried注入
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "redis")
class RedisProperties {

    private String host = "localhost";
    private String port = "6379";
    private Integer database = 0;
    private String password;
    private Long timeout = 0L;

    private Pool pool;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Pool getPool() {
        return pool;
    }

    public void setPool(Pool pool) {
        this.pool = pool;
    }

    private class Pool{
        private Integer maxActive = 8;
        private Integer maxWait = 3600;
        private Integer maxIdle = -1;
        private Integer minIdle = 0;

        public Pool() {
        }

        public Integer getMaxActive() {
            return maxActive;
        }

        public void setMaxActive(Integer maxActive) {
            this.maxActive = maxActive;
        }

        public Integer getMaxWait() {
            return maxWait;
        }

        public void setMaxWait(Integer maxWait) {
            this.maxWait = maxWait;
        }

        public Integer getMaxIdle() {
            return maxIdle;
        }

        public void setMaxIdle(Integer maxIdle) {
            this.maxIdle = maxIdle;
        }

        public Integer getMinIdle() {
            return minIdle;
        }

        public void setMinIdle(Integer minIdle) {
            this.minIdle = minIdle;
        }
    }
}
