package com.dxc.openShopReport.service.impl;

import com.dxc.openShopReport.dao.HardwareMapper;
import com.dxc.openShopReport.model.Hardware;
import com.dxc.openShopReport.service.HardwareService;
import com.dxc.openShopReport.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/11/02.
 */
@Service
@Transactional
public class HardwareServiceImpl extends AbstractService<Hardware> implements HardwareService {
    @Resource
    private HardwareMapper hardwareMapper;

}
