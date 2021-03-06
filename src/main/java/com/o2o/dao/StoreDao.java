package com.o2o.dao;

import com.o2o.entity.Store;

public interface StoreDao {

    /**
     * search store via store id
     * @param storeId
     * @return store
     */
    Store queryByStoreId(long storeId);

    /**
     * Add store
     * @param store
     * @return
     */
    int insertStore(Store store);

    /**
     * Update store
     * @param store
     * @return
     */
    int updateStore(Store store);
}
