package com.ncu.outpatient.service;

import com.ncu.pojo.common.Patient;

import java.util.List;

/**
 * @author : 城南有梦
 * @date : 2020-07-07 09:56:33
 * @description:
 */
public interface PatientService {
    //根据id获取患者
    Patient getPatientById(String id);
    //患者注册
    int register(Patient patient);
    //获取全部患者
    List<Patient> getAllPatient();
    //批量插入患者
    int registerBatch(List<Patient> patientList);
    //删除患者
    int deletePatient(String id);
    //批量删除患者
    int deleteBatch(List<String> ids);
    //选择性更新患者字段
    int updateSelective(Patient patient);
}
