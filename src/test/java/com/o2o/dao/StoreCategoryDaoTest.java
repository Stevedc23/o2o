package com.o2o.dao;

import com.o2o.BaseTest;
import com.o2o.entity.StoreCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

import java.util.List;

public class StoreCategoryDaoTest extends BaseTest {

    @Autowired
    private StoreCategoryDao storeCategoryDao;

    @Test
    public void testQueryStoreCategory() {

        List<StoreCategory> storeCategoryList = storeCategoryDao.queryStoreCategory(new StoreCategory());
        assertEquals(2,storeCategoryList.size());
        StoreCategory testCategory = new StoreCategory();
        StoreCategory parentCategory = new StoreCategory();
        parentCategory.setStoreCategoryId(1L);
        testCategory.setParent(parentCategory);
        storeCategoryList = storeCategoryDao.queryStoreCategory(testCategory);
        assertEquals(1,storeCategoryList.size());
        System.out.println(storeCategoryList.get(0).getStoreCategoryName());
    }
}
