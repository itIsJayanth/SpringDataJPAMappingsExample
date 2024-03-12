package com.example.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Category {
	@Id
	private String cid;
	private String cname;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Product> products;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String cid, String cname, List<Product> products) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.products = products;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", products=" + products + "]";
	}
	
	
	
	

}
