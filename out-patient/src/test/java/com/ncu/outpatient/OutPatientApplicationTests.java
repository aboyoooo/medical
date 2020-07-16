package com.ncu.outpatient;

import com.ncu.outpatient.mapper.PatientMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;

@SpringBootTest
class OutPatientApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Resource
    private PatientMapper patientMapper;
    @Test
    void contextLoads() {
        System.out.println(patientMapper.selectByPrimaryKey("001").toString());
    }

}