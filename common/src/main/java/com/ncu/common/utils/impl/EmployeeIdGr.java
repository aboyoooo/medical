package com.ncu.common.utils.impl;

import com.ncu.common.utils.IdGenerator;

/**
 * @author : 城南有梦
 * @date : 2020-07-12 11:34:00
 * @description:
 * 职工id生成器
 */
public class EmployeeIdGr implements IdGenerator {
    @Override
    public String generateId(String args) {
        String[] arr = args.split("-");
        int number = Integer.parseInt(arr[2]);
        number++;
        return arr[0]+"-"+arr[1]+"-"+String.format("%04d",number);
    }
}
