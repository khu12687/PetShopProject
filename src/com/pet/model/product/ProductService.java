package com.pet.model.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.pet.exception.DMLException;
import com.pet.exception.FileSaveException;
import com.pet.model.common.file.FileManager;

@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private FileManager fileManager;
	
	public void regist(Product product,MultipartFile myFile, String realPath) throws DMLException, FileSaveException{
		String filename = FileManager.saveFile(myFile,realPath);
		product.setFilename(filename);
		productDAO.insert(product);
	}
	
	public List selectAll() {
		return productDAO.selectAll();
	}
	
	public Product select(int product_id) {
		return productDAO.select(product_id);
	}
	
	public void delete(int product_id) throws DMLException{
		productDAO.delete(product_id);
	}
	
	public Product edit(int product_id) {
		
		return null;
	}
}
