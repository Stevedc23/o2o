package com.o2o.dto;

import com.o2o.entity.Store;
import com.o2o.enums.StoreStateEnum;

import java.util.List;

public class StoreExecution {

    //state status
    private int state;

    //state info
    private String stateInfo;

    //store number
    private int count;

    //store operated
    private Store store;

    // store list
    private List<Store> storeList;

    public StoreExecution() {

    }

    // store operation failed
    public StoreExecution(StoreStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    // store operation success
    public  StoreExecution(StoreStateEnum storeStateEnum, Store store) {
        this.state = storeStateEnum.getState();
        this.stateInfo = storeStateEnum.getStateInfo();
        this.store = store;
    }

    // store operation success(store list)
    public  StoreExecution(StoreStateEnum storeStateEnum, List<Store> storeList) {
        this.state = storeStateEnum.getState();
        this.stateInfo = storeStateEnum.getStateInfo();
        this.storeList = storeList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Store> getStoreList() {
        return storeList;
    }

    public void setStoreList(List<Store> storeList) {
        this.storeList = storeList;
    }
}
