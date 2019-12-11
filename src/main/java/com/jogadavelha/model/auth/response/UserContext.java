package com.jogadavelha.model.auth.response;

public class UserContext {

	private Integer userId;
	private String login;
	
	public UserContext(Integer userId, String login ) {
		this.userId = userId;
		this.login = login;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
}
