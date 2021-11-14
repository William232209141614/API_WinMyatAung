package com.lithan.winmyataung.KYN.login.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.winmyataung.KYN.login.dao.Store;
import com.lithan.winmyataung.KYN.login.repository.StoreRepository;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreRepository storeRepo;
	
	@Override
	public List<Store> viewStore() {
		return storeRepo.findAll();
	}

	@Override
	public List<Store> searchStoreByKey(String key) {
		// TODO Auto-generated method stub
		return storeRepo.searchStoreByKey(key);
	}
}

