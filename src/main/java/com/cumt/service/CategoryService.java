package com.cumt.service;

import java.util.List;

import com.cumt.pojo.Category;

public interface CategoryService {

	List<Category> list();
	Category get(int id);
}
