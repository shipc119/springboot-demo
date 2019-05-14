package com.shipc.demo.test.config.datasource;

/**
 * @ClassName DataSourceType
 * @Description
 * @Author shipc
 * @Date 2019/5/14 19:29
 * @Version 1.0
 */
public enum DataSourceType {
    MASTAR("master"),
    SLAVE("slave");

    private String type;

    DataSourceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
