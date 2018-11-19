package com.dxc.openShopReport.model;

import javax.persistence.*;

public class Brand {
    @Id
    @Column(name = "brandId")
    private Integer brandid;

    @Column(name = "brandName")
    private String brandname;

    @Column(name = "branJson")
    private String branjson;

    /**
     * @return brandId
     */
    public Integer getBrandid() {
        return brandid;
    }

    /**
     * @param brandid
     */
    public void setBrandid(Integer brandid) {
        this.brandid = brandid;
    }

    /**
     * @return brandName
     */
    public String getBrandname() {
        return brandname;
    }

    /**
     * @param brandname
     */
    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    /**
     * @return branJson
     */
    public String getBranjson() {
        return branjson;
    }

    /**
     * @param branjson
     */
    public void setBranjson(String branjson) {
        this.branjson = branjson;
    }
}