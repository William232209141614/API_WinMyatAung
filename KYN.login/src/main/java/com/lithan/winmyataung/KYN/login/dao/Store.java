package com.lithan.winmyataung.KYN.login.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	
	@Column(nullable = false)
	private String storeName;
	
	private String storeRating;
	
	private String storeDes;

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getStoreRating() {
		return storeRating;
	}

	public void setStoreRating(String storeRating) {
		this.storeRating = storeRating;
	}

	public String getStoreDes() {
		return storeDes;
	}

	public void setStoreDes(String storeDes) {
		this.storeDes = storeDes;
	}
	
}