package com.o2o.dao;

import com.o2o.entity.Area;

import java.util.List;

public interface AreaDao {

    /**
     * List the Area
     * @return areaList
     */
    List<Area> queryArea();
}
