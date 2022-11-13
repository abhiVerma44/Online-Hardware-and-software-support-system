package com.masai.models;

public class HOD {
	
	private int HOD_Id;
	private String HOD_name;
	private String HOD_username;
	private String HOD_password;
	
	public int getHOD_Id() {
		return HOD_Id;
	}
	public void setHOD_Id(int hOD_Id) {
		HOD_Id = hOD_Id;
	}
	public String getHOD_name() {
		return HOD_name;
	}
	public void setHOD_name(String hOD_name) {
		HOD_name = hOD_name;
	}
	public String getHOD_username() {
		return HOD_username;
	}
	public void setHOD_username(String hOD_username) {
		HOD_username = hOD_username;
	}
	public String getHOD_password() {
		return HOD_password;
	}
	public void setHOD_password(String hOD_password) {
		HOD_password = hOD_password;
	}
	
	public HOD() {
		// TODO Auto-generated constructor stub
	}
	
	public HOD(int hOD_Id, String hOD_name, String hOD_username, String hOD_password) {
		super();
		HOD_Id = hOD_Id;
		HOD_name = hOD_name;
		HOD_username = hOD_username;
		HOD_password = hOD_password;
	}
	@Override
	public String toString() {
		return "HOD [HOD_Id=" + HOD_Id + ", HOD_name=" + HOD_name + ", HOD_username=" + HOD_username + ", HOD_password="
				+ HOD_password + "]";
	}
	
	
	
	

}
