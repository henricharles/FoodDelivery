package service;

import java.util.List;

import domain.Category;

public interface CategoryService {
	public void createCategory(Category category);
	public List<Category> getAll();
	public Category find(int id);
	public boolean delete(Category category);
	public boolean update(Category category); 
 }
