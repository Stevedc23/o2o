package com.o2o.dao;

import com.o2o.entity.StoreCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreCategoryDao {

    List<StoreCategory> queryStoreCategory(@Param("storeCategoryCondition") StoreCategory storeCategoryCondition);
}
