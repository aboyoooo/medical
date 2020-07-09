package com.ncu.pojo.common;

import java.util.Date;

public class OutPatient {
    private String outpatientId;

    private String patientId;

    private String employeeId;

    private String departId;

    private Date registerTime;

    private String status;

    private Double registerPrice;

    private Date checkTime;

    private Double checkPrice;

    public String getOutpatientId() {
        return outpatientId;
    }

    public void setOutpatientId(String outpatientId) {
        this.outpatientId = outpatientId == null ? null : outpatientId.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId == null ? null : departId.trim();
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Double getRegisterPrice() {
        return registerPrice;
    }

    public void setRegisterPrice(Double registerPrice) {
        this.registerPrice = registerPrice;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Double getCheckPrice() {
        return checkPrice;
    }

    public void setCheckPrice(Double checkPrice) {
        this.checkPrice = checkPrice;
    }
}