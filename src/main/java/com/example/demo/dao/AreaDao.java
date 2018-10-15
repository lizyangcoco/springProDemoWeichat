package com.example.demo.dao;

import com.example.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出区域列表
     * @return areaList
     * */
    List<Area>queryArea();
    /**
     * 根据id列出具体的区域
     * @return area
     * */
    Area queryAreaById(int areaId);
    /**
     * 插入区域信息
     * @param area
     * @return
     * */
    int insertArea(Area area);
    /**
     * 更改区域信息
     * @param area
     * @return 
     * */
    int updateArea(Area area);
    /**
     * 删除区域信息
     * @return
     * */
    int deleteArea(int areaId);

}
