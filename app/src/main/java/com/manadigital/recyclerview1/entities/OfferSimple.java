package com.manadigital.recyclerview1.entities;

public class OfferSimple {
    private String discountText;
    private int imageResId;

    public OfferSimple(String discountText, int imageResId) {
        this.discountText = discountText;
        this.imageResId = imageResId;
    }

    public String getDiscountText() {
        return discountText;
    }

    public int getImageResId() {
        return imageResId;
    }
}
