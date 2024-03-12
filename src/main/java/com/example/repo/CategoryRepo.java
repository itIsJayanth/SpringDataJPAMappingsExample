package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, String> {

}
