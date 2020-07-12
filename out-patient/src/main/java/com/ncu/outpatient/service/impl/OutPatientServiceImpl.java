package com.ncu.outpatient.service.impl;

import com.ncu.outpatient.mapper.OutPatientMapper;
import com.ncu.outpatient.service.OutPatientService;
import com.ncu.pojo.common.OutPatient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : 城南有梦
 * @date : 2020-07-12 08:16:59
 * @description:
 */
@Service
public class OutPatientServiceImpl implements OutPatientService {
    @Resource
    private OutPatientMapper outPatientMapper;
    @Override
    public int makeAppointment(OutPatient outPatient){
        return outPatientMapper.insert(outPatient);
    }

    @Override
    public int giveUpNumber(OutPatient outPatient) {
        return outPatientMapper.updateByPrimaryKeySelective(outPatient);
    }
}
