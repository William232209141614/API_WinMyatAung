package com.lithan.winmyataung.KYN.login.exception;

import javax.naming.AuthenticationException;

public class OAuthAuthenticationException extends AuthenticationException{

	private static final long serialVersionUID = 1L;

	public OAuthAuthenticationException() {
		super();
	}

	public OAuthAuthenticationException(String message) {
		super(message);
	}

}
