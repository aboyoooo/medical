package com.ncu.outpatient.service.impl;

import com.ncu.outpatient.mapper.DepartmentMapper;
import com.ncu.outpatient.service.DepartmentService;
import com.ncu.pojo.common.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : 城南有梦
 * @date : 2020-07-12 14:44:49
 * @description:
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public Department findById(String id) {
        return departmentMapper.selectByPrimaryKey(id);
    }
}
