package com.digitech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digitech.dao.SupplierDAO;
import com.digitech.model.Supplier;


@Controller
public class SupplierController {
	
	@Autowired
	SupplierDAO supplierDAO;
	
	public SupplierController() 
		{ }

	@RequestMapping(value="/InsertSupplier", method=RequestMethod.GET)
	public ModelAndView addSupplier(Supplier supplier){
		
		ModelAndView mav1=new ModelAndView("supplierReg","supplier",new Supplier());
		supplierDAO.insert(supplier);
		return mav1;
	}
	}



