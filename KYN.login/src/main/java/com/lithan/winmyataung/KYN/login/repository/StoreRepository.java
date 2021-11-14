package com.lithan.winmyataung.KYN.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lithan.winmyataung.KYN.login.dao.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{
	@Query(value="SELECT s FROM Store s WHERE s.storeName LIKE '%' || :key || '%'"+
			"OR s.storeRating  LIKE '%' || :key || '%'" + 
			"OR s.storeDes  LIKE '%' || :key || '%'")
	public List<Store> searchStoreByKey(@Param ("key") String key);
	
}
