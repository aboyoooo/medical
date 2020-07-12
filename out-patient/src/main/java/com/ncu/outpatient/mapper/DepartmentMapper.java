package com.ncu.outpatient.mapper;

import com.ncu.pojo.common.Department;

public interface DepartmentMapper {
    int deleteByPrimaryKey(String departId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(String departId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
}