package com.lithan.winmyataung.KYN.login.oauth2users;

import java.util.Map;

import com.lithan.winmyataung.KYN.login.dao.AuthProvider;
import com.lithan.winmyataung.KYN.login.exception.OAuthAuthenticationException;


public class OAuth2UsersFactory {
	public static OAuth2Users getInstance(String registerId, Map<String, Object> attributes) throws OAuthAuthenticationException {
		if(registerId.equalsIgnoreCase(AuthProvider.facebook.toString())) {
			return new FacebookOAuth2Users(attributes);
		}
		else {
			throw new OAuthAuthenticationException("Login with" + registerId + "is not supported yet!!!");
		}
	}
}
