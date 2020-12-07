package com.o2o.service.impl;

import com.o2o.dao.StoreCategoryDao;
import com.o2o.entity.StoreCategory;
import com.o2o.service.StoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreCategoryServiceImpl implements StoreCategoryService {

    @Autowired
    private StoreCategoryDao storeCategoryDao;

    @Override
    public List<StoreCategory> getStoreCategorylist(StoreCategory storeCategoryCondition) {
        return storeCategoryDao.queryStoreCategory(storeCategoryCondition);
    }
}
