package com.dxc.openShopReport.model;

public class Content {
    private String id;
    private ShopContent[] content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ShopContent[] getContent() {
        return content;
    }

    public void setContent(ShopContent[] content) {
        this.content = content;
    }
}
