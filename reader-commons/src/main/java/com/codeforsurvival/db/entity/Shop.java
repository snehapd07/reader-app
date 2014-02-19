package com.codeforsurvival.db.entity;

import java.util.Map;

public class Shop {

	String shopName;
	String staffName[];
	Map<String, Integer> itemsPrice;
	

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String name) {
		this.shopName = name;
	}

	public String[] getStaffName() {
		return staffName;
	}

	public void setStaffName(String[] staffName) {
		this.staffName = staffName;
	}

	public Map<String, Integer> getItemsPrice() {
		return itemsPrice;
	}

	public void setItemsPrice(Map<String, Integer> itemsPrice) {
		this.itemsPrice = itemsPrice;
	}


}