package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Address;
import com.example.entity.Category;
import com.example.entity.Laptop;
import com.example.entity.Product;
import com.example.entity.Student;
import com.example.repo.CategoryRepo;
import com.example.repo.StudentRepo;

@Component
public class PerformOperations {

	@Autowired
	StudentRepo repo;

	@Autowired
	CategoryRepo categoryRepo;

	public void perform() {
		Student s = new Student();
		s.setName("Jayanth D");
		s.setAbout("Java L2 Developer");

		Laptop l = new Laptop();
		l.setName("MacBook Air");
		l.setModel("M2 2024,Sonoma 14.0.3");
		l.setStudent(s);

		s.setLaptop(l);
		Student save = repo.save(s);
		System.out.println(save);

	}

	public void performOneToMany() {
		Student s = new Student();
		s.setName("NikoMan");
		s.setAbout("Guard");

		Address a1 = new Address();
		a1.setCity("Bangalore");
		a1.setState("Karnataka");
		a1.setStreet("Dibburahalli");
		a1.setStudent(s);

		Address a2 = new Address();
		a2.setCity("Bnglr");
		a2.setState("Kar");
		a2.setStreet("Dib");
		a2.setStudent(s);

		s.setAddresses(List.of(a1, a2));

		Student save = repo.save(s);
		System.out.println(save);

	}

	public void checkTheRelations() {
//		Student student = repo.findById(202).get();
//		System.out.println(student);

		Category c1 = new Category();
		c1.setCid("C1");
		c1.setCname("Electronics");

		List<Product> productsForCategory1 = new ArrayList<>();
		List<Product> productsForCategory2 = new ArrayList<>();

		Category c2 = new Category();
		c2.setCid("C2");
		c2.setCname("MOBILE");

		Product p1 = new Product();
		p1.setPid("P1");
		p1.setPname("IPHONE");

		Product p2 = new Product();
		p2.setPid("P2");
		p2.setPname("Samsung s24");

		Product p3 = new Product();
		p3.setPid("P3");
		p3.setPname("Samsung Smart TV");

		productsForCategory1.add(p1);
		productsForCategory1.add(p2);
		productsForCategory1.add(p3);

		productsForCategory2.add(p1);
		productsForCategory2.add(p2);
		c1.setProducts(productsForCategory1);
		c2.setProducts(productsForCategory2);

//		categoryRepo.save(c1);
//		categoryRepo.save(c2);
		
		
		  Category category = categoryRepo.findById("C1").get();
		  System.out.println(category);
		  
		  List<Product> products = category.getProducts();
		  Category category2 = products.get(0).getCategories().get(0);
		  System.out.println(category2);
	}
}
