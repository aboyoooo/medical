package com.ncu.outpatient.mapper;

import com.ncu.pojo.common.OutPatient;

public interface OutPatientMapper {
    int deleteByPrimaryKey(String outpatientId);

    int insert(OutPatient record);

    int insertSelective(OutPatient record);

    OutPatient selectByPrimaryKey(String outpatientId);

    int updateByPrimaryKeySelective(OutPatient record);

    int updateByPrimaryKey(OutPatient record);
}