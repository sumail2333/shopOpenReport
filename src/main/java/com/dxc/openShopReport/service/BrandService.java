package com.dxc.openShopReport.service;
import com.dxc.openShopReport.model.Brand;
import com.dxc.openShopReport.core.Service;


/**
 * Created by CodeGenerator on 2018/10/25.
 */
public interface BrandService extends Service<Brand> {
    public String getJsonContentByName(String name);
}
