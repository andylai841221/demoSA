package com.sample.product.controller;

//import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sample.product.entity.Account;
import com.sample.product.entity.Manager;
import com.sample.product.entity.Product;
import com.sample.product.entity.SellList;
import com.sample.product.entity.ShoppingCart;
import com.sample.product.entity.Songs_name;
import com.sample.product.dao.ProductDAODB;
import com.sample.product.entity.ShoppingBean;
import com.sample.product.dao.ManagerDAO;
import com.sample.product.dao.ProductDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView("product");
		return model;
	}// getProductList

	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public ModelAndView shoppingcart() {

		ModelAndView model = new ModelAndView("shoppingcart");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		ShoppingBean dao2 = (ShoppingBean) context.getBean("shopping");
		List<Product> list = dao2.getList();

		model.addObject("shoppingCart", list);
		return model;
	}// getProductList
	
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public ModelAndView getProductList() {
		
		ModelAndView model = new ModelAndView("product");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		ProductDAODB daoDB = (ProductDAODB) context.getBean("productDAO");
		List<Product> list = daoDB.getList();
		/*Product p1 = dao.get(1);
		Product p2 = dao.get(2);
		Product p3 = dao.get(3);
		model.addObject("product1",p1);
		model.addObject("product2",p2);
		model.addObject("product3",p3);
		List<Product> list = dao.getList();*/
		model.addObject("productList", list);
		String filePath = "C:\\Users\\wsx98\\workspace\\DemoBean\\src\\main\\webapp\\images\\";
		model.addObject("m", filePath);		
		return model;
	}// getProductList

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		
		return getProductList();
	}// getProductList
		// list all products

	@RequestMapping(value = "/productcon", method = RequestMethod.POST)
	public ModelAndView productcon() {
		ModelAndView model = new ModelAndView("productcon");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList();
		model.addObject(list);
		return model;
	}// getProductList

	@RequestMapping(value = "/productcon", method = RequestMethod.GET)
	public ModelAndView productconUser() {
		ModelAndView model = new ModelAndView("productcon");
		String filePath = "C:\\Users\\wsx98\\workspace\\DemoBean\\src\\main\\webapp\\images\\";
		model.addObject("m", filePath);
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		List<Product> list = dao.getList();
		model.addObject(list);
		return model;
	}// getProductList

	@RequestMapping(value = "/insertProduct", method = RequestMethod.GET)
	public ModelAndView insertProductPage() {
		ModelAndView model = new ModelAndView("insertProduct");
		return model;
	}// insertProductPage

	@RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("redirect:/productcon");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
	
		dao.insert(product);
		return model;
	}// insertProduct

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@ModelAttribute Product product,@ModelAttribute ("id")long id) {
		ModelAndView model = new ModelAndView("redirect:/productcon");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		dao.delete(id);
		return model;
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.GET)
	public ModelAndView updateproductpage(@ModelAttribute("id") int id) {
		ModelAndView model = new ModelAndView("updateproduct");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");				
		Product p = dao.get(id);
		model.addObject("product", p);
		return model;
	}// insertProductPage

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public ModelAndView modify(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("redirect:/productcon");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");

		dao.update(product);
		return model;
	}// insertProduct

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView checkLogin(@ModelAttribute Account account, Manager man) {
		ModelAndView model = new ModelAndView("redirect:/product");
		Account account_session = (Account) context.getBean("account");
		ManagerDAO dao = (ManagerDAO) context.getBean("managerDAO");

		if (account.getName().equals(dao.get(account.getName()).getName())
				&& account.getPassword().equals(dao.get(account.getName()).getPassword())) {
			account_session.setName(account.getName());
			System.out.println("Success");
			model = new ModelAndView("redirect:/productcon");
		} else {
			account_session.setName("");
			System.out.println("failed");
			model = new ModelAndView("redirect:/product");

		}
		// System.out.println("model:"+account.getUsername());
		// System.out.println("session:"+account_session.getName());

		return model;
	}

	@RequestMapping(value = "/decart", method = RequestMethod.GET)
	public ModelAndView decart(@ModelAttribute ShoppingBean s, @ModelAttribute("id") int id) {
		ShoppingBean shopping = (ShoppingBean) context.getBean("shopping");

		shopping.delete(id);
		ModelAndView model = new ModelAndView("redirect:/shoppingcart");
		return model;
	}
	// insertProduct

	@RequestMapping(value = "/uploadFile", method = RequestMethod.GET)
	public ModelAndView uploadFile(@ModelAttribute Product product) {
		ModelAndView model = new ModelAndView("redirect:/productcon");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		product = dao.get(product.getProduct_id());
		long id = product.getProduct_id();
		System.out.println(id);
		model.addObject("product", product);
		return model;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ModelAndView uploadFileHandler(@ModelAttribute("file") MultipartFile file,@ModelAttribute("id")int id ) {
		ModelAndView model = new ModelAndView("redirect:/productcon");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		// save it as the file name submitted
		// String name = file.getOriginalFilename();
		
		Product product = dao.get(id);
		String name = Long.toString(id);
		String filePath = "C:\\Users\\wsx98\\workspace\\DemoBean\\src\\main\\webapp\\images\\";
		//
		File dir = new File(filePath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		try {
			file.transferTo(new File(filePath + name + ".jpg"));
			model.addObject("message", product.getProduct_id());
			model.addObject("m", filePath);
		} catch (IOException e) {
			model.addObject("message", "You failed to upload:" + file.getOriginalFilename() + " => " + e.getMessage());
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(@ModelAttribute ShoppingBean s, @ModelAttribute Product product,
			@ModelAttribute("id") int id) {
		ModelAndView model = new ModelAndView("redirect:/product");
		SellList selllist = (SellList) context.getBean("SellList");
		ShoppingBean shopping = (ShoppingBean) context.getBean("shopping");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		shopping.insert(dao.get(id));
		selllist.insert(dao.get(id));
		return model;
	}

	@RequestMapping(value = "/newuser", method = RequestMethod.GET)
	public ModelAndView newuser() {
		ModelAndView model = new ModelAndView("newuser");
		return model;
	}

	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public ModelAndView newuser(@ModelAttribute Manager manager) {
		ModelAndView model = new ModelAndView("redirect:productcon");
		ManagerDAO dao = (ManagerDAO) context.getBean("managerDAO");
		manager.setId(dao.count());
		dao.insert(manager);
		return model;
	}

	@RequestMapping(value = "/deleteShoppingcart", method = RequestMethod.GET)
	public ModelAndView deleteShoppingcart(@ModelAttribute Product product, long id) {
		ModelAndView model = new ModelAndView("redirect:/shoppingcart");
		ShoppingCart shoppingCart = (ShoppingCart) context.getBean("shoppingCart");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		product.setProduct_id(dao.count());
		dao.delete(id);
		return model;		
	}
	@RequestMapping(value = "/inf", method = RequestMethod.GET)
	public ModelAndView inf(@ModelAttribute("id") int a){		
		ModelAndView model = new ModelAndView("product_info");		
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		Product p = dao.get(a);
		model.addObject("product",p);
		return model;
		}
	@RequestMapping(value = "/name", method = RequestMethod.GET)
	public ModelAndView cat(@ModelAttribute("a") String a,@ModelAttribute("typ") String typ){
		ModelAndView model = new ModelAndView("product");		
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");			
		model.addObject("typ",typ);
		model.addObject("a",a);
		String filePath = "C:\\Users\\wsx98\\workspace\\DemoBean\\src\\main\\webapp\\images\\";
		model.addObject("m", filePath);		
		return model;
		}
	@RequestMapping(value = "/per", method = RequestMethod.POST)
	public ModelAndView per(@ModelAttribute("search") String a){
		ModelAndView model = new ModelAndView("product");		
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		System.out.println(a);
		List<Product> search =dao.searchcom(a);
		model.addObject("productList",search);
		String filePath = "C:\\Users\\wsx98\\workspace\\DemoBean\\src\\main\\webapp\\images\\";
		model.addObject("m", filePath);		
		return model;
		}
	@RequestMapping(value = "/au", method = RequestMethod.POST)
	public ModelAndView au(@ModelAttribute("searchau") String a){
		ModelAndView model = new ModelAndView("product");		
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		System.out.println(a);
		List<Product> search =dao.searchau(a);
		model.addObject("productList",search);
		String filePath = "C:\\Users\\wsx98\\workspace\\DemoBean\\src\\main\\webapp\\images\\";
		model.addObject("m", filePath);		
		return model;
		}
	
		@RequestMapping(value = "/comp", method = RequestMethod.POST)
	public ModelAndView comp(@ModelAttribute("searchcomp") String typ){
		ModelAndView model = new ModelAndView("product");		
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		System.out.println(typ);
		List<Product> search =dao.searchcomp(typ);
		model.addObject("productList",search);
		String filePath = "C:\\Users\\wsx98\\workspace\\DemoBean\\src\\main\\webapp\\images\\";
		model.addObject("m", filePath);		
		return model;
		}
		
		@RequestMapping(value = "/comp", method = RequestMethod.GET)
	public ModelAndView comp2(@ModelAttribute("searchcomp") String typ){
		ModelAndView model = new ModelAndView("product");		
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		System.out.println(typ);
		List<Product> search =dao.searchcomp(typ);
		model.addObject("productList",search);
		String filePath = "C:\\Users\\wsx98\\workspace\\DemoBean\\src\\main\\webapp\\images\\";
		model.addObject("m", filePath);		
		return model;
		}
	@RequestMapping(value = "/cat", method = RequestMethod.GET)
	public ModelAndView cat(@ModelAttribute("searchcat") String typ){
		ModelAndView model = new ModelAndView("product");		
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		System.out.println("cat="+typ);
		List<Product> search =dao.searchcat(typ);
		model.addObject("productList",search);
		String filePath = "C:\\Users\\wsx98\\workspace\\DemoBean\\src\\main\\webapp\\images\\";
		model.addObject("m", filePath);		
		return model;
		}
	
	@RequestMapping(value = "/categorysearch", method = RequestMethod.GET)
	public ModelAndView categorysearch() {
		ModelAndView model = new ModelAndView("category");
		return model;
	}// getProductList
	@RequestMapping(value = "publishsearch", method = RequestMethod.GET)
	public ModelAndView publishsearch() {
		ModelAndView model = new ModelAndView("publish");
		return model;
	}
	@RequestMapping(value = "/createPO", method = RequestMethod.GET)
	public ModelAndView createPO(@ModelAttribute("id") int id){
		ProductDAODB dao = (ProductDAODB) context.getBean("productDAO");
		Product p= dao.get(id);
		ModelAndView model = new ModelAndView("redirect:/productcon");
		dao.op(p);
		return model;
		}
	
	
}// ProductController
