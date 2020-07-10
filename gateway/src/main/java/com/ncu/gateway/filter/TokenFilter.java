package com.ncu.gateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.ncu.common.utils.JwtUtil;
import com.ncu.gateway.config.FilterWhiteList;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author : 城南有梦
 * @date : 2020-07-10 15:24:17
 * @description:
 * token拦截器
 */
@Component
public class TokenFilter implements GlobalFilter, Ordered {
    @Autowired
    private FilterWhiteList filterWhiteList;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取request和response对象
        ServerHttpRequest request =  exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        //遍历白名单
        for(String item:filterWhiteList.getAllowPaths()){
            if(request.getURI().getPath().startsWith(item)){
                //白名单直接放行
                return chain.filter(exchange);
            }
        }

        //从header中拿到token
        String token = request.getHeaders().getFirst("access_token");
        JSONObject jsonObject = new JSONObject();
        //验证
        try {
            //验证token 拿到 token中的用户名和id
            String idAndName = JwtUtil.validToken(token);
        } catch (Exception e) {
            //验证失败
            jsonObject.put("code","401");
            jsonObject.put("flag",false);
            jsonObject.put("message", "请求非法，不允许直接访问");
            jsonObject.put("data","");
            byte[] data = jsonObject.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(data);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
            return response.writeWith(Mono.just(buffer));
        }
        //放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
