package com.sample.product.entity;

import java.util.ArrayList;
import java.util.List;
import com.sample.product.dao.ProductDAO;
import com.sample.product.entity.Product;

//using List<Product> to store product
//Can't do any id change.
public class SellList implements ProductDAO{
	private List<Product> productList2 = new ArrayList<Product>();
	private int Memid;
	public SellList() {
	}

	public List<Product> getList() {
		return productList2;
	}

	public void insert(Product a) {
		Product pr = new Product();
		pr.setProduct_id(a.getProduct_id());//id++
		pr.setDiscount_date(a.getDiscount_date());//discount date++
		pr.setDiscount_price(a.getDiscount_price());//discount price++
		pr.setRel_date(a.getRel_date());//release date ++
		pr.setPath(a.getPath());//photo path
		pr.setCompany(a.getCompany());//model++
		pr.setPrice(a.getPrice());// ++
		pr.setCategory(a.getCategory());//cat+
		pr.setName(a.getName());//++
		pr.setInventory(a.getInventory());//�s�f+
		pr.setSafeInventory(a.getSafeInventory());//�w���s�f+
		pr.setAuthor(a.getAuthor());//�~�P++
		productList2.add(pr);
	}

	public Product get(long id) {
		Product p = new Product();
		for (int i = 0; i < productList2.size(); i++) {
			if (productList2.get(i).getProduct_id() == id) {
				p = productList2.get(i);
			}
		}
		return p;
	}

	public void update(Product aProduct) {
		int id = (int) aProduct.getProduct_id();
		productList2.set(id, aProduct);
	}

	public void delete(long id) {
		for (int i = 0; i < productList2.size(); i++) {
			if (productList2.get(i).getProduct_id() == id) {
				productList2.remove(i);
			break;
			}
		}
	
	}

	public int count() {
		return productList2.size();
	}

	public int total() {
		int to = 0;
		for (int i = 0; i < productList2.size(); i++) {
			to = to + (productList2.get(i).getDiscount_price());
		}
		return to;
	}
	
	public void cleanup(){
		this.getList().clear();
		
	}

	public int getMemid() {
		return Memid;
	}

	public void setMemid(int memid) {
		Memid = memid;
	}

	@Override
	public List<Product> getReorderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAvailableList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product get(Product aProduct) {
		// TODO Auto-generated method stub
		return null;
	}
}
