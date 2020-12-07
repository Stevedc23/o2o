package com.o2o.service;

import com.o2o.entity.StoreCategory;

import java.util.List;

public interface StoreCategoryService {
    List<StoreCategory> getStoreCategorylist(StoreCategory storeCategoryCondition);
}
