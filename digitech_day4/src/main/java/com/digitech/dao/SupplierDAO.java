package com.digitech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitech.model.Supplier;
import com.google.gson.Gson;

@Repository
public class SupplierDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void insertSupplier(Supplier supplier) {
		Session session=sessionFactory.openSession();
		System.out.println("Insert Method call for Supplier-Details");
		Transaction tran = session.getTransaction();
		tran.begin();
		session.save(supplier);
		session.flush();
		tran.commit();
		session.close();
		
	}
	
public String Retrieve() {
		
		Session connection = sessionFactory.openSession();
		Transaction tx = connection.getTransaction();
		tx.begin();
		
		List listdata = connection.createQuery("FROM Supplier").list();
		Gson gson = new Gson();        //google gson is used to collect data from list. it is a class. and we are accessing two toJson() method of this class.
		String jsonNames = gson.toJson(listdata);
		tx.commit();
		connection.close();
		return jsonNames;
		
	}

}
