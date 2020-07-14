package com.ncu.pojo.common;

import java.util.Date;

public class MedicalList {
    private String medicalListId;

    private String employeeId;

    private String patientId;

    private String checkId;

    private String remark;

    private Date recordTime;

    public String getMedicalListId() {
        return medicalListId;
    }

    public void setMedicalListId(String medicalListId) {
        this.medicalListId = medicalListId == null ? null : medicalListId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }
}