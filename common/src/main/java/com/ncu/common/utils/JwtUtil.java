package com.ncu.common.utils;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;

import java.text.ParseException;
import java.util.Date;

public class JwtUtil {

    private static final long EXPIRE = 18000000L;

    private static final String SECRET = "thisisasecretthisisasecretthisisasecretthisisasecret";

    /**
     * 生成token
     * subject代表token所有者，用userId作为subject
     * @return
     */
    public static String genToken(String subject,String userName) throws JOSEException {
        // 生成jwt的header
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);


        //生产payload部分
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(subject) //设置标准字段sub
                .issuer("www.demo")
                .expirationTime(new Date(System.currentTimeMillis()+EXPIRE)) //设置超时时间
                .claim("userName",userName) //设置payload中的公共属性
                .build();

        //3. 生成签名
        MACSigner macSigner = new MACSigner(SECRET);
        SignedJWT signedJWT = new SignedJWT(header, claimsSet);
        signedJWT.sign(macSigner);

        //获取字符串形式的token
        return signedJWT.serialize();
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    public static String validToken(String token) throws ParseException, JOSEException, JwtException {

        if(token==null){
            throw new JwtException("没有token");
        }

        //得到只有第三部分的jwt对象
        SignedJWT jwt = SignedJWT.parse(token);

        //获取盐的解密形式
        MACVerifier macVerifier = new MACVerifier(SECRET);
        //校验token是否能被正确解密
        if(!jwt.verify(macVerifier)){
            throw new JwtException("token不合法");
        }
        //验证是否超时
        if(new Date().after(jwt.getJWTClaimsSet().getExpirationTime())){
            throw new JwtException("token超时");
        }

        //拿到代表subject的userid
        JWTClaimsSet payload = jwt.getJWTClaimsSet();
        String userId = payload.getSubject();
        //拿公共属性 userName
        String userName = (String) payload.getClaim("userName");
        return userId+"-"+userName;
    }
}
