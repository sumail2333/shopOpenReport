package com.dxc.openShopReport.dao;

import com.dxc.openShopReport.core.Mapper;
import com.dxc.openShopReport.model.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ShopMapper extends Mapper<Shop> {
    public HashMap<String,Object> getRecordCountById(String shopCode);
    public void addNewRecords(Shop shop);
    public String getModuleValue(String shopcode);
    public List<Map<String,String>> getAllShop(@Param("brand")String brand);
}