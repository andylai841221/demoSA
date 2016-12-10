/**
 * sample program for web programming written by Ben Wu
 * reference: http://www.mkyong.com/spring/maven-spring-jdbc-example/
 */
package com.sample.product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.sample.product.entity.Product;
import com.sample.product.entity.Songs_name;

public class ProductDAODB implements ProductDAO {
	private DataSource dataSource;
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement smt = null;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Product> getList() {
		String sql = "SELECT * FROM product";
		return getList(sql);
	}

	// make it a generic method for different conditions
	public List<Product> getList(String sql) {

		List<Product> productList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Product aProduct = new Product();
				aProduct.setProduct_id(rs.getInt("product_id"));
				aProduct.setName(rs.getString("name"));
				aProduct.setTranslator(rs.getString("translator"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setPath(rs.getString("path"));
				aProduct.setAuthor(rs.getString("author"));
				aProduct.setCompany(rs.getString("company"));
				aProduct.setRel_date(rs.getDate("rel_date"));

				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount_price(rs.getInt("discount_price"));
				aProduct.setDiscount_date(rs.getDate("discount_date"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setSafeInventory(rs.getInt("safeInventory"));
			
				productList.add(aProduct);
			}
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return productList;
	}

	public void insert(Product aProduct) {

		// remove first parameter when Id is auto-increment
		String sql = "INSERT INTO product (category, name , inventory, safeInventory,author,translator,price,company,product_id,rel_date) VALUES(?, ? ,?, ?, ?, ?, ?, ?, ?,Now())";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getCategory());
			smt.setString(2, aProduct.getName());
			smt.setInt(3, aProduct.getInventory());
			smt.setInt(4, aProduct.getSafeInventory());
			smt.setString(5, aProduct.getAuthor());
			smt.setString(6, aProduct.getTranslator());
			smt.setInt(7, aProduct.getPrice());
			smt.setString(8, aProduct.getCompany());
			smt.setLong(9, aProduct.getProduct_id());
		
			
			smt.executeUpdate();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public Product get(long id) {
		Product aProduct = new Product();
		String sql = "SELECT * FROM product WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			rs = smt.executeQuery();
			if (rs.next()) {
				aProduct.setProduct_id(rs.getInt("product_id"));
				aProduct.setName(rs.getString("name"));
				aProduct.setTranslator(rs.getString("translator"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setPath(rs.getString("path"));
				aProduct.setAuthor(rs.getString("author"));
				aProduct.setCompany(rs.getString("company"));
				aProduct.setRel_date(rs.getDate("rel_date"));

				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount_price(rs.getInt("discount_price"));
				aProduct.setDiscount_date(rs.getDate("discount_date"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setSafeInventory(rs.getInt("SafeInventory"));
			}
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return aProduct;
	}

	public void update(Product aProduct) {


		String sql = "UPDATE product SET category=?, name=? , inventory=? , safeInventory=?, author=?, translator=?,price=?, company=? "
				+ "WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setString(1, aProduct.getCategory());
			smt.setString(2, aProduct.getName());
			smt.setInt(3, aProduct.getInventory());
			smt.setInt(4, aProduct.getSafeInventory());
			smt.setString(5, aProduct.getAuthor());
			smt.setString(6, aProduct.getTranslator());
			smt.setInt(7, aProduct.getPrice());
			smt.setString(8, aProduct.getCompany());
			smt.setLong(9, aProduct.getProduct_id());
			smt.executeUpdate();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public void delete(long id) {

		String sql = "DELETE FROM product WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, id);
			smt.executeUpdate();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	public int count() {
		return 0; // no longer needed
	}

	public Product get(Product aProduct) {

		String sql = "SELECT * FROM product WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setLong(1, aProduct.getProduct_id());
			rs = smt.executeQuery();
			if (rs.next()) {
				// Product aProduct=new Product();
				aProduct.setProduct_id(rs.getInt("product_id"));
				aProduct.setName(rs.getString("name"));
				aProduct.setTranslator(rs.getString("translator"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setPath(rs.getString("path"));
				aProduct.setAuthor(rs.getString("author"));
				aProduct.setCompany(rs.getString("company"));
				aProduct.setRel_date(rs.getDate("rel_date"));

				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount_price(rs.getInt("discount_price"));
				aProduct.setDiscount_date(rs.getDate("discount_date"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setSafeInventory(rs.getInt("SafeInventory"));
			}
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return aProduct;
	}

	public List<Product> getAvailableList() {
		String sql = "SELECT * FROM product WHERE Inventory > 0";
		return getList(sql);
	}

	public List<Product> getReorderList() {
		String sql = "SELECT * FROM product WHERE Inventory < ReorderPoint";
		return getList(sql);
	}

	public List<Product> searchcom(String com) {

		String sql = "select * from product where name Like '%" + com + "%'";
		System.out.println(sql);
		List<Product> productList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Product aProduct = new Product();
				aProduct.setProduct_id(rs.getInt("product_id"));
				aProduct.setName(rs.getString("name"));
				aProduct.setTranslator(rs.getString("translator"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setPath(rs.getString("path"));
				aProduct.setAuthor(rs.getString("author"));
				aProduct.setCompany(rs.getString("company"));
				aProduct.setRel_date(rs.getDate("rel_date"));

				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount_price(rs.getInt("discount_price"));
				aProduct.setDiscount_date(rs.getDate("discount_date"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setSafeInventory(rs.getInt("SafeInventory"));
				productList.add(aProduct);
			}
			System.out.println(productList.size());
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return productList;
	}

	public List<Product> searchcomp(String com) {
		String sql = "select * from product where company Like '%" + com + "%'";
		// String sql = "select * from product where "+ com2 +" Like
		// '%"+com+"%'";
		System.out.println(sql);
		List<Product> productList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Product aProduct = new Product();
				aProduct.setProduct_id(rs.getInt("product_id"));
				aProduct.setName(rs.getString("name"));
				aProduct.setTranslator(rs.getString("translator"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setPath(rs.getString("path"));
				aProduct.setAuthor(rs.getString("author"));
				aProduct.setCompany(rs.getString("company"));
				aProduct.setRel_date(rs.getDate("rel_date"));

				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount_price(rs.getInt("discount_price"));
				aProduct.setDiscount_date(rs.getDate("discount_date"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setSafeInventory(rs.getInt("SafeInventory"));
				productList.add(aProduct);
			}
			System.out.println(productList.size());
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return productList;
	}

	public List<Product> searchau(String com) {
		String sql = "select * from product where author Like '%" + com + "%'";
		// String sql = "select * from product where "+ com2 +" Like
		// '%"+com+"%'";
		System.out.println(sql);
		List<Product> productList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Product aProduct = new Product();
				aProduct.setProduct_id(rs.getInt("product_id"));
				aProduct.setName(rs.getString("name"));
				aProduct.setTranslator(rs.getString("translator"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setPath(rs.getString("path"));
				aProduct.setAuthor(rs.getString("author"));
				aProduct.setCompany(rs.getString("company"));
				aProduct.setRel_date(rs.getDate("rel_date"));

				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount_price(rs.getInt("discount_price"));
				aProduct.setDiscount_date(rs.getDate("discount_date"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setSafeInventory(rs.getInt("SafeInventory"));
				productList.add(aProduct);
			}
			System.out.println(productList.size());
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return productList;
	}

	public List<Product> searchcat(String com) {
		String sql = "select * from product where category Like '%" + com + "%'";
		// String sql = "select * from product where "+ com2 +" Like
		// '%"+com+"%'";
		System.out.println(sql);
		List<Product> productList = new ArrayList<Product>();
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			rs = smt.executeQuery();
			while (rs.next()) {
				Product aProduct = new Product();
				aProduct.setProduct_id(rs.getInt("product_id"));
				aProduct.setName(rs.getString("name"));
				aProduct.setTranslator(rs.getString("translator"));
				aProduct.setCategory(rs.getString("category"));
				aProduct.setPath(rs.getString("path"));
				aProduct.setAuthor(rs.getString("author"));
				aProduct.setCompany(rs.getString("company"));
				aProduct.setRel_date(rs.getDate("rel_date"));

				aProduct.setPrice(rs.getInt("price"));
				aProduct.setDiscount_price(rs.getInt("discount_price"));
				aProduct.setDiscount_date(rs.getDate("discount_date"));
				aProduct.setInventory(rs.getInt("inventory"));
				aProduct.setSafeInventory(rs.getInt("SafeInventory"));
				productList.add(aProduct);
			}
			System.out.println("xx "+productList.size());
			rs.close();
			smt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		return productList;
	}
	public void op(Product aProduct) {


		String sql = "UPDATE product SET inventory=? "
				+ "WHERE product_id = ?";
		try {
			conn = dataSource.getConnection();
			smt = conn.prepareStatement(sql);
			smt.setInt(1, aProduct.getSafeInventory());
			smt.setLong(2, aProduct.getProduct_id());
			smt.executeUpdate();
			smt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	
}// ProductDAOBean
