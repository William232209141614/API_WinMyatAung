package com.lithan.winmyataung.KYN.login.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.winmyataung.KYN.login.dao.Users;
import com.lithan.winmyataung.KYN.login.exception.ResourceNotFoundException;
import com.lithan.winmyataung.KYN.login.repository.UsersRepository;
import com.lithan.winmyataung.KYN.login.service.UsersPrincipal;


@RestController
@RequestMapping(value="/winmyataungKYN")
public class UsersController {
	@Autowired
    private UsersRepository userRepository;

	//Profile API <<Get Current User Profile>>
    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public Users getUser(@CurrentUser UsersPrincipal usersPrincipal) {
    	return userRepository.findById((usersPrincipal.getId())) 
                .orElseThrow(() -> new ResourceNotFoundException("Users", "Id", usersPrincipal.getId()));
    }
}
