package com.o2o.entity;

import java.util.Date;

public class StoreCategory {

    private Long storyCategoryId;
    private String storeCategoryName;
    private String storeCategoryDesc;
    private String storeCategoryImg;
    private Integer priority;
    private Date createTime;
    private Date lastEditTime;
    private StoreCategory parent;

    public Long getStoryCategoryId() {
        return storyCategoryId;
    }

    public void setStoryCategoryId(Long storyCategoryId) {
        this.storyCategoryId = storyCategoryId;
    }

    public String getStoreCategoryName() {
        return storeCategoryName;
    }

    public void setStoreCategoryName(String storeCategoryName) {
        this.storeCategoryName = storeCategoryName;
    }

    public String getStoreCategoryDesc() {
        return storeCategoryDesc;
    }

    public void setStoreCategoryDesc(String storeCategoryDesc) {
        this.storeCategoryDesc = storeCategoryDesc;
    }

    public String getStoreCategoryImg() {
        return storeCategoryImg;
    }

    public void setStoreCategoryImg(String storeCategoryImg) {
        this.storeCategoryImg = storeCategoryImg;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public StoreCategory getParent() {
        return parent;
    }

    public void setParent(StoreCategory parent) {
        this.parent = parent;
    }
}
