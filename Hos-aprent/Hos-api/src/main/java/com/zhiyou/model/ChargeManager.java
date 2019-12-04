package com.zhiyou.model;

public class ChargeManager {
    private Integer id;

    private String medicalRecord;

    private Integer payItemsId;

    private Double chargeMoney;

    private String chargeTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord == null ? null : medicalRecord.trim();
    }

    public Integer getPayItemsId() {
        return payItemsId;
    }

    public void setPayItemsId(Integer payItemsId) {
        this.payItemsId = payItemsId;
    }

    public Double getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(Double chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public String getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(String chargeTime) {
        this.chargeTime = chargeTime == null ? null : chargeTime.trim();
    }
}