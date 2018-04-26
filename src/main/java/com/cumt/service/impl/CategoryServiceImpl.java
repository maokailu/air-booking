package com.cumt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cumt.mapper.CategoryMapper;
import com.cumt.pojo.Category;
import com.cumt.service.CategoryService;

@Service
public class CategoryServiceImpl  implements CategoryService{
	@Autowired
	CategoryMapper categoryMapper;

	
	public List<Category> list(){
		return categoryMapper.list();
	};
	public Category get(int id){
		return categoryMapper.get(id);
	};

}
