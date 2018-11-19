package com.dxc.openShopReport.service.impl;

import com.dxc.openShopReport.dao.BrandMapper;
import com.dxc.openShopReport.model.Brand;
import com.dxc.openShopReport.service.BrandService;
import com.dxc.openShopReport.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/10/25.
 */
@Service
@Transactional
public class BrandServiceImpl extends AbstractService<Brand> implements BrandService {
    @Resource
    private BrandMapper brandMapper;

    public String getJsonContentByName(String name){
        return brandMapper.getJsonContentByName(name);
    }
}
