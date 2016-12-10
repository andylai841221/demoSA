package com.sample.product.dao;

import java.util.List;

import com.sample.product.entity.Product;

public interface ProductDAO {
	
	public List<Product> getList();//show list 
	public void insert(Product aProduct);
	public Product get(long id);
	public void update(Product aProduct);
	public void delete(long id);
	public int count();
	public List<Product> getReorderList();
	public List<Product> getAvailableList();
	public Product get(Product aProduct);

}//ProductDAO

