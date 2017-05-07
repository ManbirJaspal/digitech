package com.digitech.controller;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digitech.dao.UserDAO;
import com.digitech.model.User;
import com.digitech.model.UserCredentials;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userdao;
	public UserController()
	{}
	
	@RequestMapping(value ="/usersignup",method=RequestMethod.GET)
	public ModelAndView showUserdetails() 
	{	
		
		ModelAndView mvc=new ModelAndView("signup","user",new User());
		return mvc;
	}

	@RequestMapping(value="/InsertUser", method=RequestMethod.POST)
	public ModelAndView addUser(User user) 
	{
		UserCredentials userCreden= new UserCredentials();
		ModelAndView m1=new ModelAndView("signup","user",new User());
		
		userCreden.setEnabled(true);
		userCreden.setPassword(user.getPassword());
		userCreden.setRole("ROLE_USER");
		userCreden.setUsername(user.getUsername());
		
		userdao.insert(user);
		userdao.insertcreden(userCreden);
		return m1;
	}
	
	  @RequestMapping("/viewUserList")
	    public String viewUser(Model m)
	    {
	    	List list=(List) userdao.retrieveUser();
	    	System.out.println(list);
	    	m.addAttribute("list",list);
	    	return "showUser";
	    }
	  
	  @RequestMapping("/allUserList")
	    public String allUserList(Model m)
	    {
	    	List list=(List) userdao.AllUser();
	    	System.out.println(list);
	    	m.addAttribute("list",list);
	    	return "allUsers";
	    }
}
