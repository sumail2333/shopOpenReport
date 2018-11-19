package com.dxc.openShopReport.model;

import javax.persistence.*;

public class Hardware {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "Json")
    private String json;

    /**
     * @return Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Json
     */
    public String getJson() {
        return json;
    }

    /**
     * @param json
     */
    public void setJson(String json) {
        this.json = json;
    }
}