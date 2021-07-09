package com.chetmani.verchsva.bhawDetails;

import android.view.View;

public class BhawDetailsData {

    String imgUrl,itemName,bhawDetails,updatedTime;
    View line;

    public View getLine() {
        return line;
    }

    public void setLine(View line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "BhawDetailsData{" +
                "imgUrl='" + imgUrl + '\'' +
                ", itemName='" + itemName + '\'' +
                ", bhawDetails='" + bhawDetails + '\'' +
                ", updatedTime='" + updatedTime + '\'' +
                '}';
    }

    public BhawDetailsData(){

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
