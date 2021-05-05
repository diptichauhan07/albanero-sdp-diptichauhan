package com.example.demo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class user {
	
	@Id
	private String id;
	private String username;
	public String full_name;
	private String emailId;
	private String address;
	private long mobile_no;
	private String currentOrganization;
	public user(String username, String full_name, String emailId, String address, long mobile_no,
			String currentOrganization) {
		super();
		this.username = username;
		this.full_name = full_name;
		this.emailId = emailId;
		this.address = address;
		this.mobile_no = mobile_no;
		this.currentOrganization = currentOrganization;
	}
	public user() {
		super();
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "user [username=" + username + ", full_name=" + full_name + ", emailId=" + emailId + ", address="
				+ address + ", mobile_no=" + mobile_no + ", currentOrganization=" + currentOrganization + "]";
	}

}
