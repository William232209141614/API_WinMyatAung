package com.lithan.winmyataung.KYN.login.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.lithan.winmyataung.KYN.login.dao.Users;

public class UsersPrincipal implements UserDetails, OAuth2User{
	
	 private Long id;
	    private String email;
	    private String password;
	    private Collection<? extends GrantedAuthority> authorities;
	    private Map<String, Object> attributes;

	    public UsersPrincipal(Long id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
	        this.id = id;
	        this.email = email;
	        this.password = password;
	        this.authorities = authorities;
	    }

	    public static UsersPrincipal create(Users user) {
	        List<GrantedAuthority> authorities = Collections.
	                singletonList(new SimpleGrantedAuthority("ROLE_USER"));

	        return new UsersPrincipal(
	                user.getId(),
	                user.getEmail(),
	                user.getPassword(),
	                authorities
	        );
	    }

	    public static UsersPrincipal create(Users user, Map<String, Object> attributes) {
	        UsersPrincipal userPrincipal = UsersPrincipal.create(user);
	        userPrincipal.setAttributes(attributes);
	        return userPrincipal;
	    }

	    public Long getId() {
	        return id;
	    }

	    public String getEmail() {
	        return email;
	    }

	    @Override
	    public String getPassword() {
	        return password;
	    }

	    @Override
	    public String getUsername() {
	        return email;
	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return authorities;
	    }

	    @Override
	    public Map<String, Object> getAttributes() {
	        return attributes;
	    }

	    public void setAttributes(Map<String, Object> attributes) {
	        this.attributes = attributes;
	    }

	    @Override
	    public String getName() {
	        return String.valueOf(id);
	    }
	
	
}
