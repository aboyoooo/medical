package com.ncu.outpatient.service;

import com.ncu.pojo.common.Department;

/**
 * @author : 城南有梦
 * @date : 2020-07-12 14:44:13
 * @description:
 * 部门service
 */
public interface DepartmentService {
    //根据主键(id) 查询
    Department findById(String id);
}
