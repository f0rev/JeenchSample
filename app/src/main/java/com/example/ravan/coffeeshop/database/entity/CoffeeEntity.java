package com.example.ravan.coffeeshop.database.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class CoffeeEntity {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("point_id")
    @Expose
    private String pointId;

    @SerializedName("point_rank")
    @Expose
    private String pointRank;

    @SerializedName("item_id")
    @Expose
    private String itemId;

    @SerializedName("item_price")
    @Expose
    private String itemPrice;

    @SerializedName("point_time_id")
    @Expose
    private String pointTimeId;

    @SerializedName("item_bonus_price")
    @Expose
    private String itemBonusPrice;

    @SerializedName("item_shares")
    @Expose
    private String itemShares;

    @SerializedName("item_name")
    @Expose
    private String itemName;

    @SerializedName("group_type")
    @Expose
    private String groupType;

    @SerializedName("point_coords")
    @Expose
    private String pointCoords;

    @SerializedName("shop_name")
    @Expose
    private String shopName;

    @SerializedName("shop_logo")
    @Expose
    private String shopLogo;

    @SerializedName("item_is_liked")
    @Expose
    private String itemIsLiked;

    @SerializedName("shop_rank")
    @Expose
    private String shopRank;

    @SerializedName("item_likes")
    @Expose
    private String itemLikes;

    @SerializedName("shop_id")
    @Expose
    private String shopId;

    @SerializedName("item_bonus_amount")
    @Expose
    private String itemBonusAmount;

    @SerializedName("point_distance")
    @Expose
    private String pointDistance;

    @SerializedName("item_image")
    @Expose
    private String itemImage;

    @SerializedName("item_comments")
    @Expose
    private String itemComments;

    @SerializedName("point_address")
    @Expose
    private String pointAddress;

    @SerializedName("currency_id")
    @Expose
    private String currencyId;

    public void setId(int id) {
        this.id = id;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public void setPointRank(String pointRank) {
        this.pointRank = pointRank;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setPointTimeId(String pointTimeId) {
        this.pointTimeId = pointTimeId;
    }

    public void setItemBonusPrice(String itemBonusPrice) {
        this.itemBonusPrice = itemBonusPrice;
    }

    public void setItemShares(String itemShares) {
        this.itemShares = itemShares;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public void setPointCoords(String pointCoords) {
        this.pointCoords = pointCoords;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setShopLogo(String shopLogo) {
        this.shopLogo = shopLogo;
    }

    public void setItemIsLiked(String itemIsLiked) {
        this.itemIsLiked = itemIsLiked;
    }

    public void setShopRank(String shopRank) {
        this.shopRank = shopRank;
    }

    public void setItemLikes(String itemLikes) {
        this.itemLikes = itemLikes;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public void setItemBonusAmount(String itemBonusAmount) {
        this.itemBonusAmount = itemBonusAmount;
    }

    public void setPointDistance(String pointDistance) {
        this.pointDistance = pointDistance;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public void setItemComments(String itemComments) {
        this.itemComments = itemComments;
    }

    public void setPointAddress(String pointAddress) {
        this.pointAddress = pointAddress;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public int getId() {
        return id;
    }

    public String getPointId() {
        return pointId;
    }

    public String getPointRank() {
        return pointRank;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getPointTimeId() {
        return pointTimeId;
    }

    public String getItemBonusPrice() {
        return itemBonusPrice;
    }

    public String getItemShares() {
        return itemShares;
    }

    public String getItemName() {
        return itemName;
    }

    public String getGroupType() {
        return groupType;
    }

    public String getPointCoords() {
        return pointCoords;
    }

    public String getShopName() {
        return shopName;
    }

    public String getShopLogo() {
        return shopLogo;
    }

    public String getItemIsLiked() {
        return itemIsLiked;
    }

    public String getShopRank() {
        return shopRank;
    }

    public String getItemLikes() {
        return itemLikes;
    }

    public String getShopId() {
        return shopId;
    }

    public String getItemBonusAmount() {
        return itemBonusAmount;
    }

    public String getPointDistance() {
        return pointDistance;
    }

    public String getItemImage() {
        return itemImage;
    }

    public String getItemComments() {
        return itemComments;
    }

    public String getPointAddress() {
        return pointAddress;
    }

    public String getCurrencyId() {
        return currencyId;
    }
}
