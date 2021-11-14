package com.lithan.winmyataung.KYN.login.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.lithan.winmyataung.KYN.login.dao.Users;
import com.lithan.winmyataung.KYN.login.exception.ResourceNotFoundException;
import com.lithan.winmyataung.KYN.login.repository.UsersRepository;

@Service
@Transactional
public class UsersServiceImpl implements UserDetailsService{

	@Autowired
	private UsersRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users users = userRepo.findByEmail(email)
		.orElseThrow( () -> new UsernameNotFoundException("This email cannot be found" + email));
		
		return UsersPrincipal.create(users);
	}
	
	//It is used for JWT Authentication Filter
	public UserDetails loadUserById(long userId){
		Users users = userRepo.findById(userId)
		.orElseThrow( () -> new ResourceNotFoundException("Users", "userId", userId));
		
		return UsersPrincipal.create(users);
	}

}
