package com.ncu.gateway.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : 城南有梦
 * @date : 2020-07-10 21:24:26
 * @description:
 * 网关过滤白名单
 */
@Component
@Data
@ConfigurationProperties(prefix = "gateway.filter")
public class FilterWhiteList {
    private List<String> allowPaths;
}
