package com.pet.controller.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pet.controller.common.Pager;
import com.pet.exception.DMLException;
import com.pet.exception.FileSaveException;
import com.pet.model.product.Product;
import com.pet.model.product.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private Pager pager;
	
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
	public ModelAndView selectAll(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Product> productList = productService.selectAll();
		//페이징 처리 객체
		pager.init(productList, request);
		mav.addObject("productList",productList);
		mav.addObject("pager",pager);
		
		mav.setViewName("admin/product/index");
		return mav;
	}
	
	//상세보기 요청
	@RequestMapping(value="/admin/product/detail",method=RequestMethod.GET)
	public String select(Model model,@RequestParam int product_id) {
		System.out.println("product_id 는 "+product_id);
		Product product = productService.select(product_id);
		model.addAttribute("product",product);
		return "admin/product/detail";
	}
	
	//삭제 요청
	@RequestMapping(value="/admin/product/delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(Model model,@RequestParam int product_id) {
		productService.delete(product_id);
		//파일도 삭제!!
		model.addAttribute("url","/admin/product/list");
		model.addAttribute("msg","삭제 성공");
		return "view/message";
	}
	
	@ExceptionHandler({FileSaveException.class,DMLException.class})
	public ModelAndView handle(FileSaveException e,DMLException e2) {
		ModelAndView mav = new ModelAndView();
	
		//파일 업로드 에러인 경우
		if(e !=null) {
			mav.addObject("e",e);
			mav.addObject("msg",e.getMessage());
		}else if(e2 !=null) {
			mav.addObject("e",e2);
			mav.addObject("msg",e2.getMessage());
		}
		//입력 에러인 경우
		
		mav.setViewName("view/error");
		return mav;
	}
}
