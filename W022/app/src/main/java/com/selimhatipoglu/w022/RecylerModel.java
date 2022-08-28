package com.selimhatipoglu.w022;

public class RecylerModel {
    private String productname,productprice;

    public RecylerModel(String productname, String productprice) {
        this.productname = productname;
        this.productprice = productprice;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductprice() {
        return productprice;
    }

    public void setProductprice(String productprice) {
        this.productprice = productprice;
    }
}
