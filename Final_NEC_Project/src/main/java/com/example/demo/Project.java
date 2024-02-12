package com.example.demo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Project {

    @Id
    int id;
    String name;
    String email;
    String details;
    Date timeDate;
	public Project(String name, String email, String details, Date timeDate) {
		super();
		this.name = name;
		this.email = email;
		this.details = details;
		this.timeDate=timeDate;
	}
	public Project() {}
	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", email=" + email + ", details=" + details + ", timeDate="
				+ timeDate + "]";
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getTimeDate() {
		return timeDate;
	}

}
