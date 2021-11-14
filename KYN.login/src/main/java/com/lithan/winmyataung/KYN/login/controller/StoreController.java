package com.lithan.winmyataung.KYN.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.winmyataung.KYN.login.dao.Store;
import com.lithan.winmyataung.KYN.login.service.StoreService;

@RestController
@RequestMapping("/winmyataungKYN")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/view-stores")
    @PreAuthorize("hasRole('USER')")
	public List<Store> viewStore(){
		List<Store> stores = storeService.viewStore();
		return stores;
	}
	
	@GetMapping(value="/store/{key}")
	@PreAuthorize("hasRole('USER')")
	public List<Store> searchStoreByKey(@PathVariable String key){
		return storeService.searchStoreByKey(key);
		
	}
}