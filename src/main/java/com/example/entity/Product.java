package com.example.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	private String pid;
	private String pname;
	@ManyToMany(mappedBy = "products",fetch = FetchType.EAGER)
	private List<Category> categories;

	public Product() {
		
	}

	public Product(String pid, String pname, List<Category> categories) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.categories = categories;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Product pid=" + pid + ", pname=" + pname ;
	}

}
