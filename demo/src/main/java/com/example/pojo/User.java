package com.example.pojo;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;
@Table(name="sys_user")
public class User implements Serializable{
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String userName;
	private Integer level;
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
