package com.example.demo.dao;

import com.example.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)//成为单元测试类
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    @Ignore
    /**
     * queryArea测试方法
     * 
     *
     * */
    public void queryArea() {
        List<Area> areaList=areaDao.queryArea();
        assertEquals(2,((List) areaList).size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area=areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area=new Area();
        area.setAreaName("南南");
        area.setPriority(1);
        int Num=areaDao.insertArea(area);
        assertEquals(1,Num);
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area=new Area();
        area.setAreaName("南北");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int Num=areaDao.updateArea(area);
        assertEquals(1,Num);
    }

    @Test
    @Ignore
    public void deleteArea() {
        int Num=  areaDao.deleteArea(4);
        assertEquals(1,Num);
    }
}