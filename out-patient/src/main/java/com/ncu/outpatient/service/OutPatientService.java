package com.ncu.outpatient.service;

import com.ncu.pojo.common.OutPatient;

/**
 * @author : 城南有梦
 * @date : 2020-07-12 08:08:49
 * @description:
 * 门诊接口
 */
public interface OutPatientService {
    // 预约挂号
    int makeAppointment(OutPatient outPatient);

    // 门诊退号
    int giveUpNumber(OutPatient outPatient);
}
