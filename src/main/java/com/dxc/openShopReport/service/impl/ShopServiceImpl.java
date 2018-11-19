package com.dxc.openShopReport.service.impl;

import com.dxc.openShopReport.dao.ShopMapper;
import com.dxc.openShopReport.model.Shop;
import com.dxc.openShopReport.service.ShopService;
import com.dxc.openShopReport.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/10/25.
 */
@Service
@Transactional
public class ShopServiceImpl extends AbstractService<Shop> implements ShopService {
    @Resource
    private ShopMapper shopMapper;

    public HashMap<String,Object> getRecordCountById(String shopCode){
        return shopMapper.getRecordCountById(shopCode);
    }
    public void addNewRecords(Shop shop){
        shopMapper.addNewRecords(shop);
    }

    @Override
    public String getModuleValue(String shopcode) {
        return shopMapper.getModuleValue(shopcode);
    }

    @Override
    public List<Map<String,String>> getAllShop(String brand) {
        return shopMapper.getAllShop(brand);
    }


}
