package com.lithan.winmyataung.KYN.login.oauth2users;
import java.util.Map;
public class FacebookOAuth2Users extends OAuth2Users{
	public FacebookOAuth2Users(Map<String, Object> attributes) {
		super(attributes);
	}
	@Override
	public String getId() {
		return (String) attributes.get("id");
	}
	@Override
	public String getName() {
		return (String) attributes.get("name");
	}

	@Override
	public String getEmail() {
		return (String) attributes.get("email");
	}

	@Override
	public String getImageUrl() {
		if(attributes.containsKey("picture")) {
			Map<String, Object> picObj = (Map<String, Object>) attributes.get("picture");
			if(picObj.containsKey("data")) {
				Map<String, Object> dataObj = (Map<String, Object>) picObj.get("data");
				if(dataObj.containsKey("url")) {
					return (String) dataObj.get("url");
				}
			}
		}		
		return null;
	}

}
