package com.agh.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dayu on 11/2/16.
 */


@Configuration
public class MyConfig {

    @Value("${from}")
    private String from;

    public String getFrom() {
        return from;
    }
}
