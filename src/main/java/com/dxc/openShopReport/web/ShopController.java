package com.dxc.openShopReport.web;
import com.dxc.openShopReport.core.ProjectConstant;
import com.dxc.openShopReport.core.Result;
import com.dxc.openShopReport.core.ResultGenerator;
import com.dxc.openShopReport.model.Content;
import com.dxc.openShopReport.model.Shop;
import com.dxc.openShopReport.model.ShopContent;
import com.dxc.openShopReport.service.ShopService;
import com.dxc.openShopReport.util.Base64ToPic;
import com.dxc.openShopReport.util.RegexUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.*;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.*;

/**
* Created by CodeGenerator on 2018/10/25.
*/
@RestController
@RequestMapping("/shop")
public class ShopController {
    @Resource
    private ShopService shopService;

    @PostMapping(value="/getModuleValue", produces = "application/json")
    public Result getModuleValue(String shopcode,String moduleId) {
        String jsonString = shopService.getModuleValue(shopcode);
        if(jsonString == null){
            return ResultGenerator.genFailResult("没有该店信息");
        }else{
            Type type1 = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, Content.class);
            List<Content> sc = new Gson().fromJson(jsonString.toString(),type1);
            for(Content s:sc){
                if(s.getId().equals(moduleId)){
                    return ResultGenerator.genSuccessResult(s.getContent());
                }
            }
        }
        return ResultGenerator.genFailResult("没有该模块信息");
    }
    @GetMapping(value="/getAllShop", produces = "application/json")
    public Result getAllShop(@RequestParam(required = false)String brand){
        return ResultGenerator.genSuccessResult(shopService.getAllShop(brand));
    }
    @PostMapping(value="/getShop",produces = "application/json")
    public Result getShop(String shopcode) {
        String jsonString = shopService.getModuleValue(shopcode);
        if(jsonString == null){
            return ResultGenerator.genFailResult("没有该店信息");
        }else{
            Type type1 = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, Content.class);
            List<Content> sc = new Gson().fromJson(jsonString.toString(),type1);
                return ResultGenerator.genSuccessResult(sc);
            }
        }
    @PostMapping(value="/addShop")
    public Result addShop(String shopName,String shopCode,String shopBrand,String shopContent,String shopVersion) {
        HashMap<String,Object> hm = shopService.getRecordCountById(shopCode);
        Type type1 = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, Content.class);
        List<Content> c = new Gson().fromJson(shopContent,type1);
        for(Content s:c){
            transferToPic(s,shopName,shopCode);
        }
        Shop shop = new Shop();
        shop.setShopname(shopName);
        shop.setShopcode(shopCode);
        shop.setShopbrand(shopBrand);
        shop.setShopversion(shopVersion);
        shop.setShopdate(new Date());
        Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                .create();
        shop.setShopcontent(gson.toJson(c));
        if(hm != null && Integer.parseInt(hm.get("count(*)").toString()) == 1){
            return ResultGenerator.genFailResult("该店已经存在！");
        }else{
            shopService.addNewRecords(shop);
        }
        return ResultGenerator.genSuccessResult("添加成功！");
    }

    @GetMapping(value="getReportUrl")
    public Result getReportUrl(String shopCode){
        String url = ProjectConstant.REPORT_SERVER_URL+"/"+shopCode+".docx";
        return ResultGenerator.genSuccessResult(url);
    }

    public void transferToPic(Content c,String shopName,String shopCode){
        Base64ToPic b2p = new Base64ToPic();
        for(ShopContent s:c.getContent()){
            String path = null;
            if(s.getType().equals("file")){
                for(int i=0;i<s.getValue().length;i++){
                    if(RegexUtil.isHttpUrl(s.getValue()[i])){
                        continue;
                    }
                    b2p.transfer(s.getValue()[i],shopName,s.getId(),shopCode,i);
                    String suffix = s.getValue()[i].substring(s.getValue()[i].indexOf("/")+1,s.getValue()[i].indexOf(";"));
                    String id = s.getId();
                    String fileName = id+"-"+i+"."+suffix;
                    path = ProjectConstant.PCITURE_SERVER_URL+"/"+shopCode+"/" +fileName;
                    String type = s.getType();
                    s.getValue()[i] = path;
                }
            }
        }
    }
    @PostMapping(value="/newShop", produces = "application/json")
    public Result setModuleContent(String shopName,String shopCode,String shopBrand,String shopContent,String shopVersion){
        HashMap<String,Object> hm = shopService.getRecordCountById(shopCode);
        Shop shop = new Shop();
        shop.setShopname(shopName);
        shop.setShopcode(shopCode);
        shop.setShopbrand(shopBrand);
        shop.setShopversion(shopVersion);
        shop.setShopdate(new Date());
        if(hm != null && Integer.parseInt(hm.get("count(*)").toString()) == 1){
            shop.setShopid(Integer.parseInt(hm.get("shopId").toString()));
            Type type1 = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null, ArrayList.class, Content.class);
            try{
                List<Content> sc = new Gson().fromJson(hm.get("shopContent").toString(),type1);
                Content c = new Gson().fromJson(shopContent,Content.class);
                boolean bIsNew=true;
                transferToPic(c,shopName,shopCode);
                for(int i=0;i<sc.size();i++){
                    if(sc.get(i).getId().equals(c.getId())){
                        bIsNew = false;
                        sc.get(i).setContent(c.getContent());
                    }
                }
                if(bIsNew){
                    sc.add(c);
                }
                Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                        .create();
                shop.setShopcontent(gson.toJson(sc));
                shopService.update(shop);
            }catch (JsonSyntaxException e){
                return ResultGenerator.genFailResult("shopContent格式错误！");
            }
        }else{
            Content c = new Gson().fromJson(shopContent,Content.class);
            List<Content> sc = new ArrayList<Content>();
            transferToPic(c,shopName,shopCode);
            sc.add(c);
            Gson gson = new GsonBuilder().enableComplexMapKeySerialization()
                    .create();
            shop.setShopcontent(gson.toJson(sc));
            shopService.addNewRecords(shop);
        }
        return ResultGenerator.genSuccessResult("添加成功！");
    }

}
