package com.agh;


import com.agh.system.config.MyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.annotation.Resource;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Map;

@EnableDiscoveryClient
@SpringBootApplication
@ImportResource("classpath:/application-context.xml")
@EnableFeignClients
@EnableRedisHttpSession
public class Application implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Resource
    MyConfig myConfig;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... strings) throws Exception {
        logger.info(MessageFormat.format("启动时间:{0} 配置来源{1}",new Date(),myConfig.getFrom()));
        getEnv();
    }

    public void getEnv(){
        logger.info("env-----------start");
        Map<String,String> map = System.getenv();
        for (Map.Entry<String,String> entry:map.entrySet()) {
            logger.info(MessageFormat.format("key={0},value={1}",entry.getKey(),entry.getValue()));
        }
        logger.info("env-----------end.");
    }

}
