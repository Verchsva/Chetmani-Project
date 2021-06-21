package com.chetmani.verchsva.slideshow;

public class DataForImageSlider {

    private String ImageUrl;
    private String text;

    public DataForImageSlider() {
    }

    public DataForImageSlider(String imageUrl, String text) {
        ImageUrl = imageUrl;
        this.text = text;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
