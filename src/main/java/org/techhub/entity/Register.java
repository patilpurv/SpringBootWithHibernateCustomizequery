package org.techhub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity 
@Table(name="regjpa")
public class Register {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getContact() {
		return contact;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Id
	@Column(name="rid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="rname")
	private String name; 
	@Column(name="remail")
	private String email;
	@Column(name="rcontact")
	private  String contact;
	
	@Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + "]";
	}

}
