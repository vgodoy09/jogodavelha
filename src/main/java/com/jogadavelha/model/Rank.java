package com.jogadavelha.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rank")
public class Rank {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="punctuation")
	private Integer punctuation;
	@Column(name="user_id")
	private Integer user_id;
	@Column(name="play_id")
	private Integer play_id;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPunctuation() {
		return punctuation;
	}
	public void setPunctuation(Integer punctuation) {
		this.punctuation = punctuation;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getPlay_id() {
		return play_id;
	}
	public void setPlay_id(Integer play_id) {
		this.play_id = play_id;
	}
}
