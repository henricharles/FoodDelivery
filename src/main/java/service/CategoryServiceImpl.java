package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CategoryDao;
import domain.Category;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDao categoryDao;
	
	
	@Override
	public void createCategory(Category category) {
		categoryDao.save(category);
	
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.findAll();
	}

	@Override
	public Category find(int id) {
		// TODO Auto-generated method stub
		return categoryDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryDao.delete(id);
	}
	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		System.out.println(category);
		categoryDao.save(category);
	}
	
}
