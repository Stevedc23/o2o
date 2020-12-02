package com.o2o.dao;


import com.o2o.BaseTest;
import com.o2o.entity.Area;
import com.o2o.entity.Store;
import com.o2o.entity.StoreCategory;
import com.o2o.entity.UserInfo;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class StoreDaoTest extends BaseTest {

    @Autowired
    private StoreDao storeDao;

    @Test
    @Ignore
    public void testInsertStore(){
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
        store.setStoreName("Test Store");
        store.setStoreDesc("Test");
        store.setStoreAddr("test");
        store.setPhone("test");
        store.setStoreImg("test");
        store.setCreateTime(new Date());
        store.setEnableStatus(1);
        store.setAdvice("In progress");
        int effectedNum = storeDao.insertStore(store);
        assertEquals(1,effectedNum);
    }

    @Test
    public void testUpdateStore(){
        Store store = new Store();
        store.setStoreId(1L);

        store.setStoreDesc("store description");
        store.setStoreAddr("unit #, # street name, city, province, X0X 0X0");
        store.setLastEditTime(new Date());

        int effectedNum = storeDao.updateStore(store);
        assertEquals(1,effectedNum);
    }
}
