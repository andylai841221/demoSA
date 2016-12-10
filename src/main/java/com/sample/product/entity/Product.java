package com.sample.product.entity;

import java.sql.Date;

public class Product {
	private long product_id;
	private String name;
	private String translator;
	private String path;
	private String category;
	private String author;
	private String company;
	private Date rel_date;
	
	private int price;
	private int discount_price;
	private Date discount_date;
	private int safeInventory;
	private int inventory;
	
	public String getTranslator() {
		return translator;
	}
	public void setTranslator(String translator) {
		this.translator = translator;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public Date getRel_date() {
		return rel_date;
	}
	public void setRel_date(Date rel_date) {
		this.rel_date = rel_date;
	}

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount_price() {
		return discount_price;
	}
	public void setDiscount_price(int discount_price) {
		this.discount_price = discount_price;
	}
	public Date getDiscount_date() {
		return discount_date;
	}
	public void setDiscount_date(Date discount_date) {
		this.discount_date = discount_date;
	}
	public int getSafeInventory() {
		return safeInventory;
	}
	public void setSafeInventory(int safeInventory) {
		this.safeInventory = safeInventory;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	/* getters and setters */



}// Product
