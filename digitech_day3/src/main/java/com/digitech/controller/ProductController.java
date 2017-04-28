//package com.digitech.controller;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.digitech.dao.CategoryDAO;
//import com.digitech.dao.ProductDAO;
//import com.digitech.dao.SupplierDAO;
//import com.digitech.model.Product;
//
//public class ProductController {
//	
//	@Autowired
//	ProductDAO productDao;
//
//	@Autowired
//	CategoryDAO categoryDao;
//
//	@Autowired
//	SupplierDAO supplierDao;
//	public ProductController()
//	{}
//
//	@RequestMapping(value = "/showproductadmin", method = RequestMethod.GET)
//	public ModelAndView showProductAdmin() 
//	{
//
//		ModelAndView mvc = new ModelAndView("ProductAdminView", "productadmin", new Product());
//
//		String products = productDao.Retrieve();
//		String categories = categoryDao.Retrieve();
//		String suppliers = supplierDao.Retrieve();
//		mvc.addObject("mylist1", categories);
//		mvc.addObject("mylist2", suppliers);
//		mvc.addObject("mylist3", products);
//		return mvc;
//	}
//
//	@RequestMapping(value = "/insertproduct", method = RequestMethod.POST)
//	public ModelAndView addProducts(@ModelAttribute("productadmin")Product productadmin,BindingResult result) 
//	{
//		System.out.println("Working!!");
//		
//		ModelAndView m1 = new ModelAndView("ProductAdminView", "productadmin", new Product());
//		System.out.println(productadmin.getProID());
//		productDao.insertProduct(productadmin);
//		String path="C:\\DT\\digitech\\src\\main\\webapp\\resources\\images\\";
//		
//		path=path+String.valueOf(productadmin.getProID())+".jpg";
//		File file=new File(path);
//	
//		MultipartFile filedet=productadmin.getProImage();
//		
//		if(!filedet.isEmpty())
//		{
//			try
//			{
//			  byte[] bytes=filedet.getBytes();
//			  FileOutputStream fos=new FileOutputStream(file);
//              			BufferedOutputStream bs=new BufferedOutputStream(fos);
//              			bs.write(bytes);
//              			bs.close();
//              			fos.close();
//             			 System.out.println("File Uploaded Successfully");
//			}
//			catch(Exception e)
//			{
//				System.out.println("Exception Arised"+e);
//			}
//		}
//		else
//		{
//			System.out.println("File is Empty not Uploaded");
//			
//		}
//		
//		
//		 boolean data=false;
//		 String products = productDao.Retrieve();
//			String categories = categoryDao.Retrieve();
//			String suppliers = supplierDao.Retrieve();
//		 m1.addObject("checkk",data);
//		m1.addObject("mylist3", products);
//		m1.addObject("mylist1", categories);
//		m1.addObject("mylist2", suppliers);
//		return m1;
//		
//	}
//	@RequestMapping(value="/Deleteproduct", method=RequestMethod.GET)
//	public ModelAndView DeleteProduct(@RequestParam("pid")int cid)
//	{
//	
//		productDao.Delete(cid);
//		ModelAndView mvc=new ModelAndView("ProductAdminView","productadmin",new Product());
//		String products = productDao.Retrieve();
//		String categories = categoryDao.Retrieve();
//		String suppliers = supplierDao.Retrieve();
//		mvc.addObject("mylist1", categories);
//		mvc.addObject("mylist2", suppliers);
//		mvc.addObject("mylist3",products);
//		return mvc;
//	}
//	
//	@RequestMapping(value="/plzUpdatedproduct", method=RequestMethod.GET)
//	public ModelAndView plzUpdatedProduct(@RequestParam("pid")int cid)
//	{
//		Product poc=productDao.UpdateProduct(cid);
//       boolean data=true;
//		ModelAndView mvc=new ModelAndView("ProductAdminView","productadmin",poc);
//		String products = productDao.Retrieve();
//		String categories = categoryDao.Retrieve();
//		String suppliers = supplierDao.Retrieve();
//		mvc.addObject("mylist3",products);
//		mvc.addObject("mylist1", categories);
//		mvc.addObject("mylist2", suppliers);
//		mvc.addObject("checkk",data);
//	   return mvc;
//	}
//	
//	@RequestMapping(value="/plzNowUpdatedproducts", method=RequestMethod.POST)
//	public ModelAndView plzNowUpdatedProducts(HttpServletRequest request)
//	{
//		  String catID=request.getParameter("categoryID");                                                 
//		String pName=request.getParameter("proName");
//		String price=request.getParameter("price");
//		String stock=request.getParameter("stock");    
//        String description=request.getParameter("description");
//                              
//		boolean data=false;
//		int catID1=Integer.parseInt(catID);
//		int price1=Integer.parseInt(price);
//		int stock1=Integer.parseInt(stock);
//		productDao.FieldDataUpdate(catID1, pName, price1, stock1, description);
//		ModelAndView mvc=new ModelAndView("ProductAdminView","productadmin",new Product());
//		String products = productDao.Retrieve();
//		String categories = categoryDao.Retrieve();
//		String suppliers = supplierDao.Retrieve();
//		mvc.addObject("mylist3",products);
//		mvc.addObject("mylist1", categories);
//		mvc.addObject("mylist2", suppliers);
//		mvc.addObject("checkk",data);
//	   return mvc;
//	}
//
//
//
//}
//
//	
//	
//
//
