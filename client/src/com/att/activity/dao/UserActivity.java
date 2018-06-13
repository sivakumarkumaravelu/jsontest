package com.att.activity.dao;

public class UserActivity {
	
	private int userId;
	private int keyId;
	private String title;	
	private String description;
	private int[] numbers;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getKeyId() {
		return keyId;
	}
	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int[] getNumbers() {
		return numbers;
	}
	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}	
	
	@Override
	public String toString() {
		return "User Id: "+userId+"\n"+"Key Id: " +keyId+"\n"+"Title: "+title+"\n"+"Description: "+description;
	}

}
