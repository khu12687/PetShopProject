package com.pet.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pet.exception.CategoryDMLException;
import com.pet.model.category.Category;
import com.pet.model.category.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@RequestMapping(value="/category/regist", method=RequestMethod.POST)
	@ResponseBody //jsp로 결과를 보여주는 것이 아니라,
							  //데이터만 전송할 경우에 사용됨..
	public String regist(Category category) {
		System.out.println("파라미터값:"+category.getCategory_name());
		categoryService.regist(category);
		return "1";
	}
	
	//컨트롤러가 보유한 메서드들에서 예외가 발생할 경우,
	//아래의 어노테이션이 붙은 메서드가 에러를 전달받아 처리하게 된다..
	@ExceptionHandler(CategoryDMLException.class)
	@ResponseBody //페이지를 보여주는게 아닌, 데이터만 전송할 경우
	public String handle(CategoryDMLException e) {
			System.out.println("에러발견!!");
			return "0";
	}
}
