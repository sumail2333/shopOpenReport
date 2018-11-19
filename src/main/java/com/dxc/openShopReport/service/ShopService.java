package com.dxc.openShopReport.service;
import com.dxc.openShopReport.model.Shop;
import com.dxc.openShopReport.core.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018/10/25.
 */
public interface ShopService extends Service<Shop> {
    public HashMap<String,Object> getRecordCountById(String shopCode);
    public void addNewRecords(Shop shop);
    public String getModuleValue(String shopcode);
    public List<Map<String,String>> getAllShop(String brand);
}
