package com.pet.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.pet.exception.DMLException;
import com.pet.exception.FileSaveException;
import com.pet.model.product.Product;
import com.pet.model.product.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/admin/product/regist",method=RequestMethod.POST)
	public ModelAndView regist(Product product,HttpServletRequest request) {
		//파일업로드 처리~~
		
		System.out.println("카테고리 id는 "+product.getCategory().getCategory_id());
		System.out.println("상품명은 "+product.getProduct_name());
		System.out.println("가격은 "+product.getPrice());
		System.out.println("브랜드는 "+product.getBrand());
		
		//Product VO가 보유한 MultipartFile 안에 업로드된 파일 정보가
		//들어잇다.. 따라서 메모리상에서 존재하므로, 원하는 경로에 저장하자
		//MultipartFile myFile = product.getMyFile();
		//String realPath = request.getServletContext().getRealPath("/data/");
		
		//FileManager.saveFile(myFile, realPath);
		productService.regist(product, product.getMyFile(),request.getServletContext().getRealPath("/data/"));
		ModelAndView mav = new ModelAndView();
		mav.addObject("url","/admin/product/list");
		mav.addObject("msg","파일업로드 성공");
		mav.setViewName("view/message");
		return mav;	
	}
	
	@RequestMapping(value="/admin/product/list",method=RequestMethod.GET)
	public ModelAndView selectAll() {
		ModelAndView mav = new ModelAndView();
		List<Product> productList = productService.selectAll();
		mav.addObject("productList",productList);
		mav.setViewName("admin/product/index");
		return mav;
	}
	
	@ExceptionHandler({FileSaveException.class,DMLException.class})
	public ModelAndView handle(FileSaveException e,DMLException e2) {
		ModelAndView mav = new ModelAndView();
	
		//파일 업로드 에러인 경우
		if(e instanceof FileSaveException) {
			mav.addObject("e",e);
			mav.addObject("msg",e.getMessage());
		}else if(e2 instanceof DMLException) {
			mav.addObject("e",e2);
			mav.addObject("msg",e2.getMessage());
		}
		//입력 에러인 경우
		
		mav.setViewName("view/error");
		return mav;
	}
}
