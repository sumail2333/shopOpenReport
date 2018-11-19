package com.dxc.openShopReport.dao;

import com.dxc.openShopReport.core.Mapper;
import com.dxc.openShopReport.model.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface BrandMapper extends Mapper<Brand> {
    public String getJsonContentByName(String name);
}