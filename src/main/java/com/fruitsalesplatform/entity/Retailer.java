package com.fruitsalesplatform.entity;

public class Retailer extends PageEntity{
    private String mRetailerId;
    private String mName;
    private String mTelephone;
    private String mAddress;
    private int mStatus;
    private String mCreateTime;

    public String getRetailerId() {
        return mRetailerId;
    }

    public void setRetailerId(String mRetailerId) {
        this.mRetailerId = mRetailerId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getTelephone() {
        return mTelephone;
    }

    public void setTelephone(String mTelephone) {
        this.mTelephone = mTelephone;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public String getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(String mCreateTime) {
        this.mCreateTime = mCreateTime;
    }
}
