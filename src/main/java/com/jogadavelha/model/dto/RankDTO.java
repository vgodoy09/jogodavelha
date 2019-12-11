package com.jogadavelha.model.dto;

import com.jogadavelha.utils.FormatNull;

public class RankDTO {
	
	private Integer id;
	private Integer punctuation;
	private String login;
	
	public RankDTO(Object[] object) {
		this.id = FormatNull.Integer(object[0]);
		this.punctuation = FormatNull.Integer(object[1]);
		this.login = FormatNull.String(object[2]);
	}
	public Integer getPunctuation() {
		return punctuation;
	}
	public void setPunctuation(Integer punctuation) {
		this.punctuation = punctuation;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
