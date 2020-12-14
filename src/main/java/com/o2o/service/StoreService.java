package com.o2o.service;

import com.o2o.dto.StoreExecution;
import com.o2o.entity.Store;
import com.o2o.exceptions.StoreOperationException;


import java.io.InputStream;

public interface StoreService {

    /**
     * Store registration
     * @param store
     * @param storeImgInputStream
     * @param fileName
     * @return
     * @throws StoreOperationException
     */
    StoreExecution addStore(Store store, InputStream storeImgInputStream, String fileName) throws StoreOperationException;
}
