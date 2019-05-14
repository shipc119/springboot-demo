package com.shipc.demo.test.config.datasource;


/**
 * @ClassName DataSourceHolder
 * @Description
 * @Author shipc
 * @Date 2019/5/14 19:55
 * @Version 1.0
 */
public class DataSourceHolder {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    public static void setMaster() {
        local.set(DataSourceType.MASTAR.getType());
    }

    public static void setSlave() {
        local.set(DataSourceType.SLAVE.getType());
    }

    public static void put(String type) {
        local.set(type);
    }

    public static String get() {
        return (String)local.get();
    }


}
