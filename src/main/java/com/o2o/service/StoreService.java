package com.o2o.service;

import com.o2o.dto.StoreExecution;
import com.o2o.entity.Store;

import java.io.File;

public interface StoreService {

    StoreExecution addStore(Store store, File storeImg);
}
