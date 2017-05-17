package com.agh.system.controller.state;

import com.agh.system.common.RestResponse;
import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mazh on 2017/5/10.
 */
@RestController
@RequestMapping("/state/mysql")
public class MysqlController {

    @Resource
    DruidDataSource druidDataSource;

    @RequestMapping(value = "/conn")
    public RestResponse ping() {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("Username", druidDataSource.getUsername());
        data.put("ActiveCount", druidDataSource.getActiveCount());
        data.put("ActivePeak",  druidDataSource.getActivePeak());
        data.put("ActivePeakTime", druidDataSource.getActivePeakTime());
        data.put("CreateCount", druidDataSource.getCreateCount());
        data.put("ConnectCount", druidDataSource.getConnectCount());

        data.put("CloseCount", druidDataSource.getCloseCount());
        data.put("ErrorCount", druidDataSource.getConnectErrorCount());
        data.put("DestroyCount", druidDataSource.getDestroyCount());
        data.put("lock", druidDataSource.getLock());
        data.put("LockQueueLength", druidDataSource.getLockQueueLength());
        data.put("PoolingCount", druidDataSource.getPoolingCount());
        data.put("PoolingPeak", druidDataSource.getPoolingPeak());
        data.put("PoolingPeakTime", druidDataSource.getPoolingPeakTime());
        return new RestResponse(data);
    }
}
