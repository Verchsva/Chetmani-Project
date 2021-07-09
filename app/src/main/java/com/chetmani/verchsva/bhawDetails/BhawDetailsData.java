package com.chetmani.verchsva.bhawDetails;

public class BhawDetailsData {

    String imgUrl,itemName,bhawDetails,updatedTime;

    BhawDetailsData(){

    }

    public BhawDetailsData(String imgUrl, String itemName, String bhawDetails, String updatedTime) {
        this.imgUrl = imgUrl;
        this.itemName = itemName;
        this.bhawDetails = bhawDetails;
        this.updatedTime = updatedTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBhawDetails() {
        return bhawDetails;
    }

    public void setBhawDetails(String bhawDetails) {
        this.bhawDetails = bhawDetails;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
}
