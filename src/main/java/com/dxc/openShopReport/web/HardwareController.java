package com.dxc.openShopReport.web;
import com.dxc.openShopReport.core.Result;
import com.dxc.openShopReport.core.ResultGenerator;
import com.dxc.openShopReport.model.Hardware;
import com.dxc.openShopReport.service.HardwareService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/11/02.
*/
@RestController
@RequestMapping("/hardware")
public class HardwareController {
    @Resource
    private HardwareService hardwareService;

    @GetMapping(value="/getConfig", produces = "application/json")
    public Result getConfig() {
        Hardware hd = hardwareService.findById(1);
        Object[] o = new Gson().fromJson(hd.getJson(),Object[].class);
        return ResultGenerator.genSuccessResult(o);
    }

}
