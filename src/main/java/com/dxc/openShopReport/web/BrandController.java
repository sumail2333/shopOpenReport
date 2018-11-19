package com.dxc.openShopReport.web;
import com.dxc.openShopReport.core.Result;
import com.dxc.openShopReport.core.ResultGenerator;
import com.dxc.openShopReport.model.Brand;
import com.dxc.openShopReport.service.BrandService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

/**
* Created by CodeGenerator on 2018/10/25.
*/
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Resource
    private BrandService brandService;

    /**
     *
     * @param name 品牌名称如:"KFC","PHDI"
     * @return {code:200,message:"success",data:[{},{}]}
     */
    @PostMapping(value="/getJson", produces = "application/json")
    public Result getJson(String name){
        String jsonString = brandService.getJsonContentByName(name);
        Object[] objects = new Gson().fromJson(jsonString, Object[].class);
        return ResultGenerator.genSuccessResult(objects);
    }

}
