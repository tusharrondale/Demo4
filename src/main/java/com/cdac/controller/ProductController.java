package com.cdac.controller;

import java.util.List;
import java.util.Map;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.entity.Product;
import com.cdac.repository.ProductRepository;
//import com.cdac.service.ProductService;

@Controller
@CrossOrigin
public class ProductController {
	// @Autowired
	// public ProductService productService;
	@Autowired
	public ProductRepository productRepository;

	@RequestMapping("/search")
	public String search() {

		return "searchProduct";

	}

	@RequestMapping("/search_product")
	public String searchProduct(@RequestParam int id, Map map) {

		Product product = productRepository.findById(id).get();
		map.put("product1", product);
		return "product";

	}

	@RequestMapping("/productAdd")
	public String productAdd() {

		return "addProduct";

	}

	@RequestMapping("/add-product")
	public String addProduct(@RequestParam String name, @RequestParam double price, @RequestParam int quantity,
			Map map) {

		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		product.setQuantity(quantity);
		productRepository.save(product);
		map.put("add", product);
		return "dataAdd";
	}

	@RequestMapping("/productAddV2")
	public String productAdd2(Product product, Map map) {

		productRepository.save(product);
		map.put("add2", "Record Sussefully");
		return "addProduct";

	}

	@RequestMapping("/fetch-all-product")
	public String fetchAll(Map map) {

		List<Product> list = productRepository.findAll();
		map.put("fetchAll", list);
		return "viewProducts";

	}

	@RequestMapping("/hello3.cdac")
	public ModelAndView sayHello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "welcome model and view");
		mav.addObject("luckyNumber", (int) Math.ceil(Math.random() * 10));
        mav.setViewName("hello");
		return mav;
	}

}
