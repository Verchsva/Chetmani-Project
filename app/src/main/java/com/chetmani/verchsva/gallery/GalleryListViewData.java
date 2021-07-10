package com.chetmani.verchsva.gallery;

public class GalleryListViewData {

    String itemCategory;

    public GalleryListViewData() {
    }

    @Override
    public String toString() {
        return "GalleryListViewData{" +
                "itemCategory='" + itemCategory + '\'' +
                '}';
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }
}
