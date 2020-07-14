package com.pet.controller.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pet.model.product.Product;
import com.pet.model.product.ProductService;

@Controller
public class MainController {
	@Autowired
	private ProductService productService;
	
	/*----------------------------------------------------------------------------------------------
	 * 사용자 요청 처리
	 * --------------------------------------------------------------------------------------------------
	 */
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String main(Model model) {
		System.out.println("메인 호출함 ");
		
		  List<Product> productList = productService.selectAll();
		  model.addAttribute("productList", productList);
		 		 		
		return "main";	
		
	}
}