package com.shipc.demo.test.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyRoutingDataSource
 * @Description
 * @Author shipc
 * @Date 2019/5/14 19:13
 * @Version 1.0
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

    private AtomicInteger count = new AtomicInteger(0);

    private DataSource masterDataSource;
    private List<DataSource> slaveDataSources;
    private int slaveDataSourceNumber;

    public MyRoutingDataSource(DataSource masterDataSource, List<DataSource> slaveDataSources) {
        this.masterDataSource = masterDataSource;
        this.slaveDataSources = slaveDataSources;
        this.slaveDataSourceNumber = slaveDataSources.size();
    }

    @Override
    public void afterPropertiesSet() {
        if (this.masterDataSource == null) {
            throw new IllegalArgumentException("Property 'masterDataSource' is required");
        } else {
            this.setDefaultTargetDataSource(this.masterDataSource);
            Map<Object, Object> targetDataSource = new HashMap<>();
            targetDataSource.put("master", this.masterDataSource);
            if (this.slaveDataSourceNumber != 0) {
                int i = 0;
                for (Iterator iterator = this.slaveDataSources.iterator(); iterator.hasNext(); ++i) {
                    DataSource next = (DataSource)iterator.next();
                    targetDataSource.put(DataSourceType.SLAVE.getType() + i, next);  // <1> lookupKey
                }
            }
            this.setTargetDataSources(targetDataSource);
        }
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String typeKey = DataSourceHolder.get();
        if (DataSourceType.MASTAR.getType().equals(typeKey)) {
            return DataSourceType.MASTAR.getType();
        } else {
            int number = this.count.addAndGet(1);
            int lookupKey = number % this.slaveDataSourceNumber;
            return DataSourceType.SLAVE.getType() + lookupKey;  // <2> lookupKey
        }
    }
}
