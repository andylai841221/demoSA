package com.sample.product.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sample.product.dao.SalesOrderDAO;
import com.sample.product.dao.SalesOrderDAODB;
import com.sample.product.dao.ProductDAO;
import com.sample.product.dao.PurchaseOrderDAO;
import com.sample.product.entity.Product;
import com.sample.product.entity.SellList;
import com.sample.product.entity.ShoppingBean;
import com.sample.product.entity.ShoppingCart;


@Controller
public class SalesOrderController {
	ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
	//private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	//configuration for session, please refer to: http://tuhrig.de/making-a-spring-bean-session-scoped/
	
	@RequestMapping(value = "/sellcart", method = RequestMethod.GET)
	public ModelAndView shoppingcart() {

		ModelAndView model = new ModelAndView("sellcart");
		ProductDAO dao = (ProductDAO) context.getBean("productDAO");
		SellList selllist = (SellList) context.getBean("SellList");
		List<Product> list = selllist.getList();

		model.addObject("sellcart", list);
		return model;
	}// getProductList

	
	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout(){
		ModelAndView model = new ModelAndView("redirect:/product");
		ShoppingBean shoppingCart = (ShoppingBean)context.getBean("shopping");
		SalesOrderDAO salesOrderDAO = (SalesOrderDAO)context.getBean("salesOrderDAO");
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		List<Product> pList =  shoppingCart.getList();

		System.out.println("plist:"+pList.size());
		List<Long> pList2 = new ArrayList<Long>();
		for (int i=0; i<pList.size();i++){
			pList2.add(pList.get(i).getProduct_id());
		}
		int result = 0;
		try {
			result = salesOrderDAO.sellProduct(pList2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result="+result);
		if (result != 0){ //successfully updated, clean up shopping cart
			shoppingCart.cleanup();
		}
		return model;
	}
	
	@RequestMapping(value = "/sellout", method = RequestMethod.GET)
	public ModelAndView sellout(){
		ModelAndView model = new ModelAndView("redirect:/productcon");
		SellList selllist = (SellList) context.getBean("SellList");
		SalesOrderDAODB salesOrderDAODB = (SalesOrderDAODB)context.getBean("salesOrderDAO");
		PurchaseOrderDAO purchaseOrderDAO = (PurchaseOrderDAO)context.getBean("purchaseOrderDAO");
		List<Product> pList =  selllist.getList();

		System.out.println("plist:"+pList.size());
		List<Long> pList2 = new ArrayList<Long>();
		for (int i=0; i<pList.size();i++){
			pList2.add(pList.get(i).getProduct_id());
		}
		int result = 0;
		try {
			result = salesOrderDAODB.SellOut(pList2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result="+result);
		if (result != 0){ //successfully updated, clean up shopping cart
			selllist.cleanup();
		}
		return model;
	}
}
