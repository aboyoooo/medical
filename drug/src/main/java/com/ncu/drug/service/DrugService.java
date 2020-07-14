package com.ncu.drug.service;


import com.ncu.drug.mapper.DrugMapper;
import com.ncu.drug.pojo.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugService {

    @Autowired
    private DrugMapper drugMapper;

    public Drug queryById(Long id){
        return drugMapper.selectByPrimaryKey(id);
    }
}
