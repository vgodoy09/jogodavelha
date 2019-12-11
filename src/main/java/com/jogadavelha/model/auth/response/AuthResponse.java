package com.jogadavelha.model.auth.response;

public class AuthResponse {

	private String token;
	private String message;
	private UserContext userContext;
	private Boolean error;
	
	public AuthResponse(String token, String message, UserContext userContext, Boolean error) {
		this.token = token;
		this.message = message;
		this.userContext = userContext;
		this.error = error;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(UserContext userContext) {
		this.userContext = userContext;
	}
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
}
