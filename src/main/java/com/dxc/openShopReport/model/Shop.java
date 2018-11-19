package com.dxc.openShopReport.model;

import java.util.Date;
import javax.persistence.*;

public class Shop {
    @Id
    @Column(name = "shopId")
    private Integer shopid;

    @Column(name = "shopName")
    private String shopname;

    @Column(name = "shopCode")
    private String shopcode;

    @Column(name = "shopBrand")
    private String shopbrand;

    @Column(name = "shopContent")
    private String shopcontent;

    @Column(name = "shopVersion")
    private String shopversion;

    @Column(name = "shopDate")
    private Date shopdate;

    /**
     * @return shopId
     */
    public Integer getShopid() {
        return shopid;
    }

    /**
     * @param shopid
     */
    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    /**
     * @return shopName
     */
    public String getShopname() {
        return shopname;
    }

    /**
     * @param shopname
     */
    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    /**
     * @return shopCode
     */
    public String getShopcode() {
        return shopcode;
    }

    /**
     * @param shopcode
     */
    public void setShopcode(String shopcode) {
        this.shopcode = shopcode;
    }

    /**
     * @return shopBrand
     */
    public String getShopbrand() {
        return shopbrand;
    }

    /**
     * @param shopbrand
     */
    public void setShopbrand(String shopbrand) {
        this.shopbrand = shopbrand;
    }

    /**
     * @return shopContent
     */
    public String getShopcontent() {
        return shopcontent;
    }

    /**
     * @param shopcontent
     */
    public void setShopcontent(String shopcontent) {
        this.shopcontent = shopcontent;
    }

    /**
     * @return shopVersion
     */
    public String getShopversion() {
        return shopversion;
    }

    /**
     * @param shopversion
     */
    public void setShopversion(String shopversion) {
        this.shopversion = shopversion;
    }

    /**
     * @return shopDate
     */
    public Date getShopdate() {
        return shopdate;
    }

    /**
     * @param shopdate
     */
    public void setShopdate(Date shopdate) {
        this.shopdate = shopdate;
    }
}