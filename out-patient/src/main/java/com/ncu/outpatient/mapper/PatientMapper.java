package com.ncu.outpatient.mapper;

import com.ncu.pojo.common.Patient;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PatientMapper {
    int deleteByPrimaryKey(String patientId);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(String patientId);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);

    List<Patient> findAll();

    int insertBatch(@Param(value = "patientList") List<Patient> patientList);

    int deleteBatch(@Param(value = "ids") List<String> ids);
}