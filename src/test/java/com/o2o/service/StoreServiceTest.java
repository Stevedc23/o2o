package com.o2o.service;

import com.o2o.BaseTest;
import com.o2o.dto.StoreExecution;
import com.o2o.entity.Area;
import com.o2o.entity.Store;
import com.o2o.entity.StoreCategory;
import com.o2o.entity.UserInfo;
import com.o2o.enums.StoreStateEnum;
import com.o2o.exceptions.StoreOperationException;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class StoreServiceTest extends BaseTest {

    @Autowired
    private StoreService storeService;

    @Test
    public void testModifyStore() throws StoreOperationException, FileNotFoundException {
        Store store = new Store();
        store.setStoreId(1L);
        store.setStoreName("Pang Ya mart");

        File storeImg = new File("F:\\Java\\ohayo.jpg");
        InputStream is = new FileInputStream(storeImg);
        StoreExecution storeExecution = storeService.modifyStore(store, is, "ohayo.jpg");
        System.out.println("New Pic address : " + storeExecution.getStore().getStoreImg());
    }

    @Test
    @Ignore
    public void testAddStore() throws StoreOperationException, FileNotFoundException {
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
        store.setStoreName("Test Store3");
        store.setStoreDesc("Test3");
        store.setStoreAddr("test3");
        store.setPhone("test3");

        store.setCreateTime(new Date());
        store.setEnableStatus(StoreStateEnum.CHECK.getState());
        store.setAdvice("In progress");

        File storeImg = new File("F:\\Java\\tree.jpg");

        InputStream inputStream = new FileInputStream(storeImg);

        StoreExecution se = storeService.addStore(store, inputStream, storeImg.getName());
        assertEquals(StoreStateEnum.CHECK.getState(), se.getState());
    }
}
