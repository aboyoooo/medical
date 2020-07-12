package com.ncu.common.utils.impl;

import com.ncu.common.utils.IdGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author : 城南有梦
 * @date : 2020-07-12 08:39:09
 * @description:
 * 门诊id生成器
 */
public class OutPatientIdGr implements IdGenerator {
    @Override
    public String generateId(String args) {
        //id由3部分组成 第一部分是时间 第二部分是传入的参数 第三部分是4位随机数
        String id;
        Date date= new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        //将时间里面的- : 以及空格全部换成空字符
        id = time.replaceAll("[-: ]+","")+"-"+args;
        //生成四位随机数 1000-9999
        Random random = new Random();
        id = id+"-"+(random.nextInt(9000)+1000);
        return id;
    }
}
