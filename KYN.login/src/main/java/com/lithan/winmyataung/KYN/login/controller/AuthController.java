package com.lithan.winmyataung.KYN.login.controller;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lithan.winmyataung.KYN.login.dao.AuthProvider;
import com.lithan.winmyataung.KYN.login.dao.Users;
import com.lithan.winmyataung.KYN.login.exception.BadRequestException;
import com.lithan.winmyataung.KYN.login.jwtsecurity.TokenProvider;
import com.lithan.winmyataung.KYN.login.payload.Login;
import com.lithan.winmyataung.KYN.login.payload.LoginResponse;
import com.lithan.winmyataung.KYN.login.payload.Register;
import com.lithan.winmyataung.KYN.login.payload.RegisterResponse;
import com.lithan.winmyataung.KYN.login.repository.UsersRepository;


@RestController
@RequestMapping("/winmyataungKYN")
public class AuthController {
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	//Register User for Local 
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody Register register){
		//Checking duplicate email
		if(usersRepository.existsByEmail(register.getEmail())) {
			throw new BadRequestException("Email has already registered before so kindly try anthoner email");
		}
		
		//Create new register user
		Users users = new Users();
		users.setName(register.getName());
		users.setEmail(register.getEmail());
		users.setPassword(register.getPassword());
		users.setProvider(AuthProvider.local);
		

		users.setPassword(passwordEncoder.encode(users.getPassword()));
		
		Users newUser = usersRepository.save(users);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(newUser.getId()).toUri();

		return ResponseEntity.created(location)
				.body(new RegisterResponse(true, "User has successfully registered!!!"));
	}

	@PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Login login) {

	 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		login.getEmail(),
                		login.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenProvider.createToken(authentication);
        
 
        return ResponseEntity.ok(new LoginResponse(token));
    }
	
}
