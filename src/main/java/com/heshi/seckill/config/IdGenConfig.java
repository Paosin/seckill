package com.heshi.seckill.config;

import com.heshi.seckill.utils.SnowflakeIdWorker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Paosin
 * @version 1.0
 * @className IdGenConfig
 * @date 2018/3/30 23:34
 */
@Configuration
public class IdGenConfig {
    @Value("${id.gen.worker}")
    private Long workerId;
    @Value("${id.gen.datacenter}")
    private Long datacenterId;

    @Bean
    public SnowflakeIdWorker snowflakeIdWorker() {
        return new SnowflakeIdWorker(workerId, datacenterId);
    }
}
