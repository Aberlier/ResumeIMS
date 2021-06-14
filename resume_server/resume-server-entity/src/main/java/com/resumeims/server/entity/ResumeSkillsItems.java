package com.resumeims.server.entity;

import java.util.Date;

public class ResumeSkillsItems {
    private Long itemId;

    private String itemOne;

    private String itemOneValue;

    private String itemTwo;

    private String itemTwoValue;

    private String itemThrid;

    private String itemThridValue;

    private String itemFour;

    private String itemFourValue;

    private String itemFive;

    private String itemFiveValue;

    private String itemSix;

    private String itemSixValue;

    private Long createUser;

    private Long updateUser;

    private Date createTime;

    private Date updateTime;

    public ResumeSkillsItems(Long itemId, String itemOne, String itemOneValue, String itemTwo, String itemTwoValue, String itemThrid, String itemThridValue, String itemFour, String itemFourValue, String itemFive, String itemFiveValue, String itemSix, String itemSixValue, Long createUser, Long updateUser, Date createTime, Date updateTime) {
        this.itemId = itemId;
        this.itemOne = itemOne;
        this.itemOneValue = itemOneValue;
        this.itemTwo = itemTwo;
        this.itemTwoValue = itemTwoValue;
        this.itemThrid = itemThrid;
        this.itemThridValue = itemThridValue;
        this.itemFour = itemFour;
        this.itemFourValue = itemFourValue;
        this.itemFive = itemFive;
        this.itemFiveValue = itemFiveValue;
        this.itemSix = itemSix;
        this.itemSixValue = itemSixValue;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ResumeSkillsItems() {
        super();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemOne() {
        return itemOne;
    }

    public void setItemOne(String itemOne) {
        this.itemOne = itemOne == null ? null : itemOne.trim();
    }

    public String getItemOneValue() {
        return itemOneValue;
    }

    public void setItemOneValue(String itemOneValue) {
        this.itemOneValue = itemOneValue == null ? null : itemOneValue.trim();
    }

    public String getItemTwo() {
        return itemTwo;
    }

    public void setItemTwo(String itemTwo) {
        this.itemTwo = itemTwo == null ? null : itemTwo.trim();
    }

    public String getItemTwoValue() {
        return itemTwoValue;
    }

    public void setItemTwoValue(String itemTwoValue) {
        this.itemTwoValue = itemTwoValue == null ? null : itemTwoValue.trim();
    }

    public String getItemThrid() {
        return itemThrid;
    }

    public void setItemThrid(String itemThrid) {
        this.itemThrid = itemThrid == null ? null : itemThrid.trim();
    }

    public String getItemThridValue() {
        return itemThridValue;
    }

    public void setItemThridValue(String itemThridValue) {
        this.itemThridValue = itemThridValue == null ? null : itemThridValue.trim();
    }

    public String getItemFour() {
        return itemFour;
    }

    public void setItemFour(String itemFour) {
        this.itemFour = itemFour == null ? null : itemFour.trim();
    }

    public String getItemFourValue() {
        return itemFourValue;
    }

    public void setItemFourValue(String itemFourValue) {
        this.itemFourValue = itemFourValue == null ? null : itemFourValue.trim();
    }

    public String getItemFive() {
        return itemFive;
    }

    public void setItemFive(String itemFive) {
        this.itemFive = itemFive == null ? null : itemFive.trim();
    }

    public String getItemFiveValue() {
        return itemFiveValue;
    }

    public void setItemFiveValue(String itemFiveValue) {
        this.itemFiveValue = itemFiveValue == null ? null : itemFiveValue.trim();
    }

    public String getItemSix() {
        return itemSix;
    }

    public void setItemSix(String itemSix) {
        this.itemSix = itemSix == null ? null : itemSix.trim();
    }

    public String getItemSixValue() {
        return itemSixValue;
    }

    public void setItemSixValue(String itemSixValue) {
        this.itemSixValue = itemSixValue == null ? null : itemSixValue.trim();
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}