package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empe {
	@Id
	int id;
	String username;
	int age;
	int sal;
	String password;
	
	

	public Empe(int id, String username, int age, int sal, String password) {
		super();
		this.id = id;
		this.username = username;
		this.age = age;
		this.sal = sal;
		this.password = password;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public int getSal() {
		return sal;
	}



	public void setSal(int sal) {
		this.sal = sal;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Empe [id=" + id + ", username=" + username + ", age=" + age + ", sal=" + sal + ", password=" + password
				+ "]";
	}



	public Empe() {}

}