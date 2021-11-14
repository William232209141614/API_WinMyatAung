package com.lithan.winmyataung.KYN.login.service;



import java.util.List;

import com.lithan.winmyataung.KYN.login.dao.Store;

public interface StoreService {
	public List<Store> viewStore();
	public List<Store> searchStoreByKey(String key);
}