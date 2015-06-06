package com.tenchael.android.template.commons;

public class Constants {

	private Constants() {
		/* cannot be instantiated */
		throw new UnsupportedOperationException("cannot be instantiated");
	}

	public static final String SERVER_BASE_ADDRESS = "http://192.168.1.107:8080/web/rest";
	public static final String HTTPS_BASE_ADDRESS = "https://192.168.1.107:8443/web/rest";

	public static final String INFO_BASE = "/v2/info";
	public static final String INFO_LOCATION_URL = HTTPS_BASE_ADDRESS
			+ INFO_BASE + "/location";
	public static final String INFO_URL = HTTPS_BASE_ADDRESS + INFO_BASE;

	public static final String USER_BASE = "/user";
	public static final String USER_REGISTER_URL = HTTPS_BASE_ADDRESS
			+ USER_BASE + "/register";
	public static final String USER_LOGIN_URL = HTTPS_BASE_ADDRESS + USER_BASE
			+ "/login";

}
