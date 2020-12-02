package com.o2o.service.impl;

import com.o2o.dao.StoreDao;
import com.o2o.dto.StoreExecution;
import com.o2o.entity.Store;
import com.o2o.enums.StoreStateEnum;
import com.o2o.exceptions.StoreOperationException;
import com.o2o.service.StoreService;
import com.o2o.util.ImageUtil;
import com.o2o.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Date;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreDao storeDao;

    @Override
    @Transactional
    public StoreExecution addStore(Store store, File storeImg) {
        if(store == null) {
            return new StoreExecution(StoreStateEnum.NULL_STORE);
        }
        try {
            store.setEnableStatus(0);
            store.setCreateTime(new Date());
            store.setLastEditTime(new Date());
            int effectedNum = storeDao.insertStore(store);
            if(effectedNum <= 0) {
                throw new StoreOperationException("Create Store Failed");
            } else {
                if(storeImg != null) {
                    //save store images
                    try {
                        addStoreImg(store, storeImg);
                    } catch (Exception e) {
                        throw new StoreOperationException("addStoreImg error:" + e.getMessage());
                    }

                    //update the path of store images
                    effectedNum = storeDao.updateStore(store);
                    if(effectedNum <= 0) {
                        throw new StoreOperationException("update Store images Failed");
                    }
                }
            }

        } catch (Exception e) {
            throw new StoreOperationException("addStore error:" + e.getMessage());
        }
        return new StoreExecution(StoreStateEnum.CHECK, store);
    }

    private void addStoreImg(Store store, File storeImg) {

        //Get relative path of store images
        String desc = PathUtil.getStoreImagePath(store.getStoreId());
        String storeImgAddr = ImageUtil.generateThumbnail(storeImg, desc);
        store.setStoreImg(storeImgAddr);
    }
}
