package com.digitech.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitech.model.Category;
import com.google.gson.Gson;


@Repository
public class CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertCategory(Category category) {
		Session session=sessionFactory.openSession();
		System.out.println("Insert Method call for Category-Details");
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(category);
		session.flush();
		tran.commit();
		session.close();
	}
	
	public List<Category> getCategoryList() {
		
		Session session=sessionFactory.openSession();
		ArrayList<Category> categoryList =(ArrayList<Category>)session.createQuery("from Category").list();
		session.close();
		return categoryList;
	}
	
	public void deleteCategory(int catID) {
		Session session = sessionFactory.openSession();
		Category cat = (Category)session.get(Category.class, (Integer)catID);
		session.delete(cat);
		session.flush();
		System.out.println("Category Deleted");
		session.close();
		
		}
	
public String Retrieve() {
		
		Session connection = sessionFactory.openSession();
		Transaction tx = connection.getTransaction();
		tx.begin();
		
		List listdata = connection.createQuery("FROM Category").list();
		Gson gson = new Gson();        //google gson is used to collect data from list. it is a class. and we are accessing two toJson() method of this class.
		String jsonNames = gson.toJson(listdata);
		tx.commit();
		connection.close();
		return jsonNames;
		
	}
}
