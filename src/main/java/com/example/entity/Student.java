package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String about;
	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	// if i save this automatically laptop also will be saved but laptop class is
	// the "student" has to be same as it is written in the laptop class.
	private Laptop laptop;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	// if we save the student address will also be saved
	private List<Address> addresses;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Student() {
		
	
	}

	public Student(int id, String name, String about, Laptop laptop) {
		super();
		this.id = id;
		this.name = name;
		this.about = about;
		this.laptop = laptop;
	}

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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", about=" + about + ", laptop=" + laptop + ", addresses="
				+ addresses + "]";
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", about=" + about + "]";
//	}

}
