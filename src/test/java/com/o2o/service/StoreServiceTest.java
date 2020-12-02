package com.o2o.service;

import com.o2o.BaseTest;
import com.o2o.dto.StoreExecution;
import com.o2o.entity.Area;
import com.o2o.entity.Store;
import com.o2o.entity.StoreCategory;
import com.o2o.entity.UserInfo;
import com.o2o.enums.StoreStateEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class StoreServiceTest extends BaseTest {

    @Autowired
    private StoreService storeService;

    @Test
    public void testAddStore(){
        Store store = new Store();
        UserInfo owner = new UserInfo();
        Area area = new Area();
        StoreCategory storeCategory = new StoreCategory();

        owner.setUserId(1L);
        area.setAreaId(2);
        storeCategory.setStoreCategoryId(1L);

        store.setOwner(owner);
        store.setArea(area);
        store.setStoreCategory(storeCategory);
        store.setStoreName("Test Store1");
        store.setStoreDesc("Test1");
        store.setStoreAddr("test1");
        store.setPhone("test1");

        store.setCreateTime(new Date());
        store.setEnableStatus(StoreStateEnum.CHECK.getState());
        store.setAdvice("In progress");

        File storeImg = new File("F:\\Java\\tree.jpg");

        StoreExecution se = storeService.addStore(store, storeImg);
        assertEquals(StoreStateEnum.CHECK.getState(), se.getState());
    }
}
