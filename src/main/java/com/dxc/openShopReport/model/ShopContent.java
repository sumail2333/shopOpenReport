package com.dxc.openShopReport.model;

public class ShopContent {
    private String id;
    private String type;
    private String[] value;
    private String docType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String[] getValue() {
        return value;
    }

    public void setValue(String[] value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }
}
