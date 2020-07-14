package com.ncu.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.config.GlobalCorsProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

/**
 * @author : 城南有梦
 * @date : 2020-07-11 11:30:33
 * @description:
 */
@Configuration
public class CorsConfig {
    @Autowired
    private GlobalCorsProperties globalCorsProperties;
    /**
     * 测试，灰度，正式环境使用
     * @return
     */
    @Bean
    @Profile({"test","pre","pro"})
    public CorsWebFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        globalCorsProperties.getCorsConfigurations().forEach((path,corsConfiguration)->source.registerCorsConfiguration(path, corsConfiguration));
        return new CorsWebFilter(source);
    }

}
