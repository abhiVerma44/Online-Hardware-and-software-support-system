package com.masai.models;

public class Engineer {

	private int Engineer_Id;
	private String Engineer_name;
	private String Engineer_username;
	private String Engineer_password;
	private String Engineer_category;
	public int getEngineer_Id() {
		return Engineer_Id;
	}
	public void setEngineer_Id(int engineer_Id) {
		Engineer_Id = engineer_Id;
	}
	public String getEngineer_name() {
		return Engineer_name;
	}
	public void setEngineer_name(String engineer_name) {
		Engineer_name = engineer_name;
	}
	public String getEngineer_username() {
		return Engineer_username;
	}
	public void setEngineer_username(String engineer_username) {
		Engineer_username = engineer_username;
	}
	public String getEngineer_password() {
		return Engineer_password;
	}
	public void setEngineer_password(String engineer_password) {
		Engineer_password = engineer_password;
	}
	public String getEngineer_category() {
		return Engineer_category;
	}
	public void setEngineer_category(String engineer_category) {
		Engineer_category = engineer_category;
	}
	@Override
	public String toString() {
		return "Engineer [Engineer_Id=" + Engineer_Id + ", Engineer_name=" + Engineer_name + ", Engineer_username="
				+ Engineer_username + ", Engineer_password=" + Engineer_password + ", Engineer_category="
				+ Engineer_category + "]";
	}
	
	public Engineer() {
		// TODO Auto-generated constructor stub
	}
	public Engineer( String engineer_name, String engineer_username, String engineer_password,
			String engineer_category) {
		super();
		
		Engineer_name = engineer_name;
		Engineer_username = engineer_username;
		Engineer_password = engineer_password;
		Engineer_category = engineer_category;
	}
	public Engineer(int engineer_Id, String engineer_name, String engineer_username, String engineer_password,
			String engineer_category) {
		super();
		Engineer_Id = engineer_Id;
		Engineer_name = engineer_name;
		Engineer_username = engineer_username;
		Engineer_password = engineer_password;
		Engineer_category = engineer_category;
	}
	
	
}
